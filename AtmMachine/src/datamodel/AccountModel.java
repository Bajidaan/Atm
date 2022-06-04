package datamodel;

import Util.SQLiteConnection;

import java.sql.Connection;

public class AccountModel {
    private static AccountModel instance = new AccountModel();
    Connection connection;
    String sql = "SELECT * FROM Information WHERE username = ?";

    public AccountModel() {
        connection = SQLiteConnection.connector();

        if (connection == null) {
            System.exit(1);
        }
    }







}
