package account;

import AtmLogin.ATMController;
import AtmLogin.LoginModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccountDetailsController {
    ATMController atmController = new ATMController();

    @FXML
    private Button okButton;


    @FXML
    private Text textBalance;

    public void initialize() {
        textBalance.setText("#" + String.valueOf(LoginModel.getInstance().getAccount().getBalance()));

    }

    public void oKAndBackButtonPressed() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        atmController.accountLogin("/account/account.fxml", "Account", 600, 550);

    }
}
