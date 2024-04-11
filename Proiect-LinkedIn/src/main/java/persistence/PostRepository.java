package persistence;

import database.DatabaseConnection;
import model.Post;
import java.sql.*;
import java.util.ArrayList;

public class PostRepository {

    private final DatabaseConnection db;

    public PostRepository(DatabaseConnection connection) {
        this.db = connection;
    }

    public void add(Post post) {
        String sql = "INSERT INTO posts (title, subject, nameOfUser) VALUES (?, ?, ?)";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getSubject());
            statement.setString(3, post.getNameOfUser());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Post get(int id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Post(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("subject"),
                        resultSet.getString("nameOfUser")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Post> getAllForUser(String nameOfUser) {
        ArrayList<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts WHERE nameOfUser = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, nameOfUser);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                posts.add(new Post(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("subject"),
                        nameOfUser
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public void update(Post post) {
        String sql = "UPDATE posts SET title = ?, subject = ? WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getSubject());
            statement.setInt(3, post.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Post post) {
        String sql = "DELETE FROM posts WHERE id = ?";
        try (PreparedStatement statement = db.connection.prepareStatement(sql)) {
            statement.setInt(1, post.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
