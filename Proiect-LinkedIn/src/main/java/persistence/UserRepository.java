package persistence;

import database.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository implements GenericRepository<User> {
    private final DatabaseConnection db;
    private EducationRepository _educationRepository;
    private ExperienceRepository _experienceRepository;
    private CertificationRepository _certificationRepository;

    public UserRepository(DatabaseConnection connection) {
        this.db = connection;
        _educationRepository = new EducationRepository(connection);
        _experienceRepository = new ExperienceRepository(connection);
        _certificationRepository = new CertificationRepository(connection);
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (username, email, password, full_name, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFullName());
            String userType = "unknown";
            if (user instanceof BackendDeveloper) {
                userType = "backend_developer";
            } else if (user instanceof FrontendDeveloper) {
                userType = "frontend_developer";
            } else if (user instanceof FullstackDeveloper) {
                userType = "fullstack_developer";
            } else if (user instanceof Student) {
                userType = "student";
            }

            statement.setString(5, userType);
            statement.executeUpdate();
            for (Education e : user.getEducation()) {
                _educationRepository.add(e);
            }
            for (Experience e : user.getExperience()) {
                _experienceRepository.add(e);
            }
            for (Certification c : user.getCertifications()) {
                _certificationRepository.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ?, full_name = ? WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFullName());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
            for (Education e : user.getEducation()) {
                _educationRepository.upsert(e);
            }
            for (Experience e : user.getExperience()) {
                _experienceRepository.upsert(e);
            }
            for (Certification c : user.getCertifications()) {
                _certificationRepository.upsert(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, user.getId());
            statement.executeUpdate();
            for (Education e : user.getEducation()) {
                _educationRepository.delete(e);
            }
            for (Experience e : user.getExperience()) {
                _experienceRepository.delete(e);
            }
            for (Certification c : user.getCertifications()) {
                _certificationRepository.delete(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
