package Util;

//INSERT INTO Information (Account Name, Account Number, Balance, username, password) VALUES('samueal Ola', '3242345688',
//2000, 'dan', 'zxc');

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    private static final String SQLITE = "jdbc:sqlite:AccountSystem.db";

    public static Connection connector() {
        try {
            return DriverManager.getConnection(SQLITE);
        } catch (SQLException e) {
            System.out.println("Caused by: " + e.getCause());
        }
        return null;
    }
}
