
package Customer.Controller.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

// Kết nối tới DataBase của hệ thống

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection(){
    }

    // Thực hiện kết nối tới cơ sở dữ liệu
    public void connectToDatabase() throws SQLException {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_QLNhaHang";
        final String username = "sa";
        final String password = "123";
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

