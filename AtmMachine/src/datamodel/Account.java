package datamodel;

public class Account {
    private String accountName;
    private String accountNumber;
    private String username;
    private String password;
    private double balance;

    public Account(String accountName, String accountNumber, String username, String password, double balance) {
        if (balance < 100) {
            throw new IllegalArgumentException("You must deposit at least #100");
        }
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.balance = balance;

    }

    // Getter and setter
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    } // End of Getter and setter

    // Deposit your money
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("You can't deposit #" + amount);
        }
        balance = balance + amount;
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount >= balance )
            throw new IllegalArgumentException("Insufficient account balance");

        balance = balance - amount;
    }

    //transfer money
    public void transfer(Double amount) {
        if (amount >= balance )
            throw new IllegalArgumentException("Insufficient account balance");

        balance = balance - amount;
    }
}
