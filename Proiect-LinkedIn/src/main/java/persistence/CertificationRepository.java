package persistence;

import database.DatabaseConnection;
import model.Certification;
import model.Experience;
import service.AuditService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CertificationRepository {

    private final DatabaseConnection db;

    public CertificationRepository(DatabaseConnection connection) {
        this.db = connection;
    }

    public void add(Certification certification) {
        String sql = "INSERT INTO certifications (name, issuingOrganization, startDate, endDate, user_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, certification.getName());
            statement.setString(2, certification.getIssuingOrganization());
            statement.setDate(3, Date.valueOf(certification.getStartDate()));
            statement.setDate(4, Date.valueOf(certification.getEndDate()));
            statement.setInt(5, certification.getUserId());
            statement.executeUpdate();
            AuditService.logAction("ADD_CERTIFICATION");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Certification get(int id) {
        String sql = "SELECT * FROM certifications WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            AuditService.logAction("READ_CERTIFICATION");
            if (resultSet.next()) {
                return new Certification(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("issuingOrganization"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate(),
                        resultSet.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Certification> getAllForUser(int userId) {
        ArrayList<Certification> certifications = new ArrayList<>();
        String sql = "SELECT * FROM certifications WHERE user_id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            AuditService.logAction("READ_CERTIFICATIONS_FOR_USER");
            while (resultSet.next()) {
                certifications.add(new Certification(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("issuingOrganization"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate") != null ? resultSet.getDate("endDate").toLocalDate() : null,
                        userId
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certifications;
    }

    public void update(Certification certification) {
        String sql = "UPDATE certifications SET name = ?, issuingOrganization = ?, startDate = ?, endDate = ? WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, certification.getName());
            statement.setString(2, certification.getIssuingOrganization());
            statement.setDate(3, Date.valueOf(certification.getStartDate()));
            statement.setDate(4, Date.valueOf(certification.getEndDate()));
            statement.setInt(5, certification.getId());
            statement.executeUpdate();
            AuditService.logAction("UPDATE_CERTIFICATION");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upsert(Certification certification) {
        if (certification.getId() > 0 && exists(certification.getId())) {
            update(certification);
        } else {
            add(certification);
        }
    }

    private boolean exists(int id) {
        String sql = "SELECT id FROM certifications WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(Certification certification) {
        String sql = "DELETE FROM certifications WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, certification.getId());
            statement.executeUpdate();
            AuditService.logAction("DELETE_CERTIFICATION");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
