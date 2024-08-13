package Customer.Controller.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDatabase {

    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_QLNhaHang";
    private static final String userName = "sa";
    private static final String password = "123";

    public static Connection ConnectData() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                Connection ketNoi = DriverManager.getConnection(url, userName, password);
                return ketNoi;
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
