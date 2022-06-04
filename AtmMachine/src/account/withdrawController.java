package account;

import AtmLogin.ATMController;
import AtmLogin.LoginModel;
import datamodel.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class withdrawController {
    ATMController atmController = new ATMController();
    @FXML
    private TextField amountWithdraw;

    @FXML
    private Button backButton;

    @FXML
    private Button changePinButton;

    @FXML
    private Button depositButton;

    @FXML
    private TextField amountTransfer;

    @FXML
    private Button transferButton;

    ActionEvent event;

    @FXML
    private TextField transferUsername;

    @FXML
    private TextField amountDeposit;

    @FXML
    private Button withdrawButton;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private TextField username;

    @FXML
    public void initialize(){
        withdrawButton.setDisable(true);
        //depositButton.setDisable(true);
        //transferButton.setDisable(true);
       // changePinButton.setDisable(true);
    }

    @FXML
    void backButtonPressed() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        atmController.accountLogin("/account/account.fxml", "Account", 600, 550);
    }

    @FXML
    public void proceedButtonPressed(ActionEvent event) {
        if (event.getSource().equals(withdrawButton)) {
            withdrawButtonPressed();
        } else if (event.getSource().equals(depositButton)) {
            depositButtonPressed();
        } else if(event.getSource().equals(changePinButton)) {
            changeButtonPressed();
        } else if (event.getSource().equals(transferButton)) {
            transferButtonPressed();
        }
    }

    public void withdrawButtonPressed() {
        Double amount = Double.valueOf(amountWithdraw.getText());
        Account account = LoginModel.getInstance().getAccount();

        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Insufficient fund");
        }
        amountWithdraw.setText("");
        LoginModel.getInstance().update(account.getBalance(), account.getUsername());
    }

    public void depositButtonPressed() {
        Double amount = Double.valueOf(amountDeposit.getText());
        Account account = LoginModel.getInstance().getAccount();
        account.deposit(amount);
        amountDeposit.setText("");
        LoginModel.getInstance().update(account.getBalance(), account.getUsername());
    }

    public void changeButtonPressed() {
        LoginModel.getInstance().changePassword(oldPassword.getText(), newPassword.getText(), username.getText());
        username.setText("");
        oldPassword.setText("");
        newPassword.setText("");
    }

    @FXML
    public void keyReleased() {
        String text = amountWithdraw.getText();
        Boolean disableButton = text.isEmpty() || text.trim().isEmpty();

        withdrawButton.setDisable(disableButton);
    }

    public void transferButtonPressed() {
        String name = transferUsername.getText().trim();
        double amount = Double.parseDouble(amountTransfer.getText()) ;
        Account account = LoginModel.getInstance().getAccount();
        double currentBalance = LoginModel.getInstance().getBalance(name);
        double newBalance = amount + currentBalance;

        try {
            account.transfer(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("You can't transfer this amount");
        }
        LoginModel.getInstance().update(newBalance, name);
        LoginModel.getInstance().update(account.getBalance(), account.getUsername());

        amountTransfer.setText("");
        transferUsername.setText("");
    }
}

