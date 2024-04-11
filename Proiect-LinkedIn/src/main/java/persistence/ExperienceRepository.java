package persistence;

import database.DatabaseConnection;
import model.Education;
import model.Experience;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExperienceRepository {

    private final DatabaseConnection db;

    public ExperienceRepository(DatabaseConnection connection) {
        this.db = connection;
    }

    public void add(Experience experience) {
        String sql = "INSERT INTO experience (jobRole, companyName, startDate, endDate, employmentType, location, locationType, currentlyWorking, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, experience.getJobRole());
            statement.setString(2, experience.getCompanyName());
            statement.setDate(3, Date.valueOf(experience.getStartDate()));
            statement.setDate(4, experience.getEndDate() == null ? null : Date.valueOf(experience.getEndDate()));
            statement.setString(5, experience.getEmploymentType());
            statement.setString(6, experience.getLocation());
            statement.setString(7, experience.getLocationType());
            statement.setBoolean(8, experience.isCurrentlyWorking());
            statement.setInt(9, experience.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Experience get(int id) {
        String sql = "SELECT * FROM experience WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Experience(
                        resultSet.getInt("id"),
                        resultSet.getString("jobRole"),
                        resultSet.getString("companyName"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate") != null ? resultSet.getDate("endDate").toLocalDate() : null,
                        resultSet.getString("employmentType"),
                        resultSet.getString("location"),
                        resultSet.getString("locationType"),
                        resultSet.getBoolean("currentlyWorking"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Experience> getAllForUser(int userId) {
        ArrayList<Experience> experiences = new ArrayList<>();
        String sql = "SELECT * FROM experience WHERE user_id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                experiences.add(new Experience(
                        resultSet.getInt("id"),
                        resultSet.getString("jobRole"),
                        resultSet.getString("companyName"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate") != null ? resultSet.getDate("endDate").toLocalDate() : null,
                        resultSet.getString("employmentType"),
                        resultSet.getString("location"),
                        resultSet.getString("locationType"),
                        resultSet.getBoolean("currentlyWorking"),
                        userId
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return experiences;
    }

    public void update(Experience experience) {
        String sql = "UPDATE experience SET jobRole = ?, companyName = ?, startDate = ?, endDate = ?, employmentType = ?, location = ?, locationType = ?, currentlyWorking = ? WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, experience.getJobRole());
            statement.setString(2, experience.getCompanyName());
            statement.setDate(3, Date.valueOf(experience.getStartDate()));
            statement.setDate(4, experience.getEndDate() == null ? null : Date.valueOf(experience.getEndDate()));
            statement.setString(5, experience.getEmploymentType());
            statement.setString(6, experience.getLocation());
            statement.setString(7, experience.getLocationType());
            statement.setBoolean(8, experience.isCurrentlyWorking());
            statement.setInt(9, experience.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upsert(Experience experience) {
        if (experience.getId() > 0 && exists(experience.getId())) {
            update(experience);
        } else {
            add(experience);
        }
    }
    private boolean exists(int id) {
        String sql = "SELECT id FROM experience WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(Experience experience) {
        String sql = "DELETE FROM experience WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, experience.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
