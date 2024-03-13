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
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.boImpl.AdminBoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.util.Regex;
import lk.ijse.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class AdminSignInFormController {

    public TextField txtAdminFName;
    public AnchorPane subroot;
    public TextField txtAdminPW;
    public TextField txtAdminLName;
    public TextField txtAdminEmail;
    public Button btnAdminSignin;
    public Button btnAdminCrtAcc;

    private AdminBo adminBo = new AdminBoImpl();


    public void btnAdminSigninOnAction(ActionEvent actionEvent) throws IOException {
        //navigateToMainWindow();
        //adminDashboardFormController.initialize();

        Parent node = FXMLLoader.load(this.getClass().getResource("/view/admin_login_form.fxml"));

        this.subroot.getChildren().clear();
        this.subroot.getChildren().add(node);

    }
   /* private void navigateToMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);

        subroot.getChildren().clear();
        Stage primaryStage = (Stage) subroot.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");

    }*/


    public void btnAdminCrtAccOnAction(ActionEvent actionEvent) {

        if(!validate()){
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields with valid data").show();
            return;
        }

        AdminDto adminDto = collectData();
        try {
            AdminDto isSaved = adminBo.addAdmin(adminDto);
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

    private AdminDto collectData(){
        AdminDto adminDto = new AdminDto();
        adminDto.setFirstName(txtAdminFName.getText());
        adminDto.setLastName(txtAdminLName.getText());
        adminDto.setEmail(txtAdminEmail.getText());
        adminDto.setPassword(txtAdminPW.getText());

        System.out.println("Creating admin account...");
        System.out.println("First Name: " + txtAdminFName.getText());
        System.out.println("Last Name: " + txtAdminLName.getText());
        System.out.println("Email: " + txtAdminEmail.getText());
        System.out.println("Password: " + txtAdminPW.getText());

        return adminDto;
    }

    public void txtAdminFNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtAdminFName);
    }

    public void txtAdminPWOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PASSWORD,txtAdminPW);
    }

    public void txtAdminLNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtAdminLName);
    }

    public void txtAdminEmailOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.EMAIL,txtAdminEmail);

    }

    public boolean validate(){
        return  Regex.isTextFieldValid(TextFields.NAME,txtAdminFName.getText()) &&
                Regex.isTextFieldValid(TextFields.NAME,txtAdminLName.getText()) &&
                Regex.isTextFieldValid(TextFields.EMAIL,txtAdminEmail.getText()) &&
                Regex.isTextFieldValid(TextFields.PASSWORD,txtAdminPW.getText());
    }

    private void clearTextFields() {
        txtAdminFName.setText("");
        txtAdminLName.setText("");
        txtAdminEmail.setText("");
        txtAdminPW.setText("");
    }

}

