package AtmLogin;

import Util.SQLiteConnection;
import datamodel.Account;

import java.sql.*;
import java.util.ArrayList;

public class LoginModel {

    private static LoginModel instance = new LoginModel();
    String sql = "SELECT * FROM Information WHERE username = ?";
    Connection connection;
    ArrayList<Account> accountData;

    private String accountName = null;
    private String accountNumber = null;
    private double balance = 0;
    private String userName = null;
    private String pass_word = null;

    private LoginModel() {
        connection = SQLiteConnection.connector();

        if (connection == null)
            System.exit(1);
    }

    public static LoginModel getInstance() {
        return instance;
    }

    public boolean isSQLiteConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            System.out.println("Caused by: " + e.getCause());
            return false;
        }
    }

    // Check if username and password is correct
    public boolean isLogin(String username, String password) {
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            String passWord;
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                passWord = resultSet.getString("password");

                if (passWord.equals(password)) {
                    accountName = resultSet.getString(1);
                    accountNumber = resultSet.getString(2);
                    balance = resultSet.getDouble(3);
                    userName = resultSet.getString("username");
                    pass_word = resultSet.getString("password");

                    return true;
                }

            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database : " + e.getMessage());
            return false;
        }
        return false;
    }

    public Account getAccount() {
        return new Account(accountName, accountNumber, userName, pass_word, balance);
    }

    public void update(double set, String position) {
        String query = "UPDATE Information SET Balance = ? WHERE username = ?";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDouble(1, set);
            preparedStmt.setString(2, position);
            preparedStmt.executeUpdate();

            //connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getBalance(String username) {
        double balance = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet result = ps.executeQuery();

            balance = result.getDouble("Balance");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return balance;
    }
    
    public void changePassword(String oldPassword, String newPassword, String username) {
        String query = "UPDATE Information SET password = ? WHERE password = ? and username = ?";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, newPassword);
            preparedStmt.setString(2, oldPassword);
            preparedStmt.setString(3, username);
            preparedStmt.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}










