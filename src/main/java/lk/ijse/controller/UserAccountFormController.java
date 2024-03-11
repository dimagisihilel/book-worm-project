package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserAccountFormController {
    public Label lblUserName;
    public Button btnUpdateUser;
    public TextField txtFName;
    public TextField txtLName;
    public TextField txtEmail;
    public TextField txtPW;
    private UserDashboardFormController userDashboardFormController;

    public void setParentController(UserDashboardFormController userDashboardFormController) {
        this.userDashboardFormController = userDashboardFormController;
    }

    public void btnUpdateUserOnAction(ActionEvent actionEvent) {
    }
}
