package account;

import AtmLogin.ATMController;
import AtmLogin.LoginModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccountController {

    ATMController atmController = new ATMController();


    @FXML
    private Button balanceButton;

    @FXML
    private Button changePinButton;

    @FXML
    private Button depositButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button transferButton;

    @FXML
    private Button withdrawButton;

    @FXML
    private Button okButton;

    @FXML
    public void  balanceButtonPressed() {
        Stage stage = (Stage) balanceButton.getScene().getWindow();
        stage.close();

        atmController.accountLogin("/account/balanceFxml.fxml", "Balance", 600, 550);

    }

    @FXML
    public void withDrawButtonPressed() {
        Stage stage = (Stage) withdrawButton.getScene().getWindow();
        stage.close();
        atmController.accountLogin("/account/withdraw/withdraw.fxml", "Withdraw", 600, 550);
    }

    @FXML
    public void depositButtonPressed() {
        Stage stage = (Stage) depositButton.getScene().getWindow();
        stage.close();
        atmController.accountLogin("/account/depositFxml.fxml", "Deposit", 600, 550);
    }

    @FXML
    public void changePinButtonPressed() {
        Stage stage = (Stage) changePinButton.getScene().getWindow();
        stage.close();
        atmController.accountLogin("/account/changePin.fxml", "Deposit", 600, 550);
    }

    @FXML
    public void transferButtonPressed() {
        Stage stage = (Stage) transferButton.getScene().getWindow();
        stage.close();
        //  atmController.accountLogin("/account/balanceFxml.fxml", "Balance", 600, 550);
        atmController.accountLogin("/account/transfer.fxml", "transfer", 600, 550);
    }

    @FXML
    public void oKButtonPressed() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        atmController.accountLogin("/account/account.fxml", "Account", 600, 550);
    }

    @FXML
    public void logOutButtonPressed() {
        System.exit(0);
    }

}
