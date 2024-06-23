package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url       = "jdbc:postgresql://localhost:5432/musica";
    private static String username  = "postgres";
    private static String password  = "2104";
    private static Connection connection; // Singleton

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
