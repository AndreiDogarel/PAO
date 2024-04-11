package persistence;

import database.DatabaseConnection;
import model.Education;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository {

    private final DatabaseConnection db;

    public EducationRepository(DatabaseConnection connection) {
        this.db = connection;
    }

    public void add(Education education) {
        String sql = "INSERT INTO education (schoolName, degree, fieldOfStudy, startDate, endDate, grade, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, education.getSchoolName());
            statement.setString(2, education.getDegree());
            statement.setString(3, education.getFieldOfStudy());
            statement.setDate(4, Date.valueOf(education.getStartDate()));
            statement.setDate(5, Date.valueOf(education.getEndDate()));
            statement.setString(6, education.getGrade());
            statement.setInt(7, education.getUserId()); // Presupunem că există un getter pentru userId în Education
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Education get(int id) {
        String sql = "SELECT * FROM education WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Education(
                        resultSet.getInt("id"),
                        resultSet.getString("schoolName"),
                        resultSet.getString("degree"),
                        resultSet.getString("fieldOfStudy"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate(),
                        resultSet.getString("grade"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Education> getAllForUser(int userId) {
        ArrayList<Education> educations = new ArrayList<>();
        String sql = "SELECT * FROM education WHERE user_id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Education education = new Education(
                        resultSet.getInt("id"),
                        resultSet.getString("schoolName"),
                        resultSet.getString("degree"),
                        resultSet.getString("fieldOfStudy"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("endDate").toLocalDate(),
                        resultSet.getString("grade"),
                        resultSet.getInt("user_id")
                );
                educations.add(education);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educations;
    }

    public void update(Education education) {
        String sql = "UPDATE education SET schoolName = ?, degree = ?, fieldOfStudy = ?, startDate = ?, endDate = ?, grade = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, education.getSchoolName());
            statement.setString(2, education.getDegree());
            statement.setString(3, education.getFieldOfStudy());
            statement.setDate(4, Date.valueOf(education.getStartDate()));
            statement.setDate(5, Date.valueOf(education.getEndDate()));
            statement.setString(6, education.getGrade());
            statement.setInt(7, education.getUserId());
            statement.setInt(8, education.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upsert(Education education) {
        if (education.getId() > 0 && exists(education.getId())) {
            update(education);
        } else {
            add(education);
        }
    }
    private boolean exists(int id) {
        String sql = "SELECT id FROM education WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(Education education) {
        String sql = "DELETE FROM education WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, education.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
