package AtmLogin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ATMController {
    @FXML
    private Label labeConnect;

    @FXML
    private PasswordField password;


    @FXML
    private TextField username;

    @FXML
    private Button exitButton;

    @FXML
    private Button loginButton;

    public String getUsername() {
        return username.getText();
    }

    public void initialize() {
        if (LoginModel.getInstance().isSQLiteConnected())
            labeConnect.setText("connected");
        else
            labeConnect.setText("Not connected");

        loginButton.setDisable(true);

    }

    @FXML
    public void loginButtonPressed() {
        if (LoginModel.getInstance().isLogin(username.getText(), password.getText())) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            accountLogin("/account/account.fxml", "Account", 600, 550);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Wrong User Name or Password");
            alert.showAndWait();
        }
    }

    public void accountLogin(String path, String tittle, int v, int v1) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource(path).openStream());

            stage.setTitle(tittle);
            stage.setResizable(false);
            stage.setScene(new Scene(root,v, v1));
            stage.show();


        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @FXML
    public void keyRelease() {
        onKeyRelease(username, loginButton);
        onKeyRelease(password, loginButton);
    }

    public void onKeyRelease(TextField t, Button btn) {
        String text = t.getText();
        Boolean disableButton = text.isEmpty() || text.trim().isEmpty();

        btn.setDisable(disableButton);
    }
}
