package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.bo.custom.boImpl.UserBoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;
import lk.ijse.util.Regex;
import lk.ijse.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class UserSignInFormController {

    public Button btnUSignIn;
    public TextField txtUserEmail;
    public TextField txtuserLName;
    public TextField txtUserFName;
    public AnchorPane subroot;
    public TextField txtUserPW;
    public Button btnUserCrteAcc;
    private UserBo userBo = new UserBoImpl();

    public void btnUSignInOnAction(ActionEvent actionEvent) throws IOException {
       // navigateToMainWindow();
        //userDashboardFormController.initialize();

        Parent node = FXMLLoader.load(this.getClass().getResource("/view/user_login_form.fxml"));

        this.subroot.getChildren().clear();
        this.subroot.getChildren().add(node);
    }
   /* private void navigateToMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);

        subroot.getChildren().clear();
        Stage primaryStage = (Stage) subroot.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");

    }*/
    public void btnUserCrteAccOnAction(ActionEvent actionEvent) {

        if(!validate()){
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields with valid data").show();
            return;
        }

        UserDto userDto = collectData();
        try {
            UserDto isSaved = userBo.addUser(userDto);
            if (isSaved != null) {
                new Alert(Alert.AlertType.INFORMATION, "Saved").show();
                clearTextFields();
            }else{
                new Alert(Alert.AlertType.ERROR, "Not Saved").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }
    private UserDto collectData(){
        UserDto userDto = new UserDto();
        userDto.setFirstName(txtUserFName.getText());
        userDto.setLastName(txtuserLName.getText());
        userDto.setEmail(txtUserEmail.getText());
        userDto.setPassword(txtUserPW.getText());
        return userDto;
    }

    public void txtUserFNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtUserFName);
    }

    public void txtUserLNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtuserLName);
    }

    public void txtUserEmailOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.EMAIL,txtUserEmail);
    }

    public void txtUserPWOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PASSWORD,txtUserPW);
    }
    public boolean validate(){
        return Regex.isTextFieldValid(TextFields.NAME,txtUserFName.getText()) &&
                Regex.isTextFieldValid(TextFields.NAME,txtuserLName.getText()) &&
                Regex.isTextFieldValid(TextFields.EMAIL,txtUserEmail.getText()) &&
                Regex.isTextFieldValid(TextFields.PASSWORD,txtUserPW.getText());
    }
    public void clearTextFields(){
        txtUserFName.setText("");
        txtuserLName.setText("");
        txtUserEmail.setText("");
        txtUserPW.setText("");
    }
}
