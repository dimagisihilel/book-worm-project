package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.bo.custom.boImpl.UserBoImpl;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public class UserAccountFormController {
    public Label lblUserName;
    public Button btnUpdateUser;
    public TextField txtFName;
    public TextField txtLName;
    public TextField txtEmail;
    public TextField txtPW;
    private UserDashboardFormController userDashboardFormController;
    UserBo userBo = new UserBoImpl();
    private int activeUserId;

    public void setParentController(UserDashboardFormController userDashboardFormController) {
        this.userDashboardFormController = userDashboardFormController;
    }

    public void btnUpdateUserOnAction(ActionEvent actionEvent) {
        // Get the updated user data from the text fields
        String firstName = txtFName.getText();
        String lastName = txtLName.getText();
        String email = txtEmail.getText();
        String password = txtPW.getText();

        // Create a UserDto object with the updated data
        UserDto updatedUser = new UserDto(activeUserId, firstName, lastName, email, password);

        // Update the user in the database
        UserDto result = userBo.updateUser(updatedUser);

        if (result != null) {
            // Update successful
            new Alert(Alert.AlertType.INFORMATION, "User details updated successfully").show();
        } else {
            // Update failed
            new Alert(Alert.AlertType.ERROR, "Failed to update user details").show();
        }
    }

    public void setUserId(int activeUserId) {
        this.activeUserId = activeUserId;
        loadUserData();
    }

    public void setUserName(String text) {
        lblUserName.setText(text);
    }
    private void loadUserData() {
        // Get user data from the database based on the active user ID
        UserDto userDto = userBo.getUserById(activeUserId);

        // Set the user data to the text fields
        txtFName.setText(userDto.getFirstName());
        txtLName.setText(userDto.getLastName());
        txtEmail.setText(userDto.getEmail());
        txtPW.setText(userDto.getPassword());
    }
}
