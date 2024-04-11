package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/login_schema";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "Oppaibankai123@";
    private static DatabaseConnection instance;
    public static Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
