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

public class AdminLoginFormController {

    public AnchorPane subroot;
    public Button btnAdminLogIn;
    public Button btnAdminSignIn;
    public TextField txtALoginEmail;
    public TextField txtALoginPW;

    private AdminBo adminBo = new AdminBoImpl();


    public void btnAdminSignInOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/admin_signin_form.fxml"));

        this.subroot.getChildren().clear();
        this.subroot.getChildren().add(node);
    }

    public void btnAdminLogInOnAction(ActionEvent actionEvent) throws IOException {

        String email = txtALoginEmail.getText();
        String password = txtALoginPW.getText();

        try {
            AdminDto adminDto = adminBo.loginAdmin(email, password);
            if (adminDto != null) {
               // navigateToMainWindow();
                openAdminDashboard(adminDto.getAdminId(),adminDto.getFirstName() + " " + adminDto.getLastName());
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid Email or password").show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An error occurred while logging in").show();
        }
        //navigateToMainWindow();
    }
    /*private void navigateToMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);

        subroot.getChildren().clear();
        Stage primaryStage = (Stage) subroot.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");

    }*/
    private void openAdminDashboard(int adminId,String adminName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin_dashboard_form.fxml"));
        Parent rootNode = loader.load();

        // Pass admin name and id to the dashboard controller
        AdminDashboardFormController controller = loader.getController();
        controller.setAdminId(adminId);
        controller.setAdminName(adminName);

        Scene scene = new Scene(rootNode);

        Stage primaryStage = (Stage) subroot.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");
    }

    public void txtALoginEmailOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.EMAIL,txtALoginEmail);
    }

    public void txtALoginPWOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PASSWORD,txtALoginPW);
    }
}
