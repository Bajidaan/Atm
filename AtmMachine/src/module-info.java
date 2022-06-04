module AtmMachine {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    opens AtmLogin;
    opens account;
}