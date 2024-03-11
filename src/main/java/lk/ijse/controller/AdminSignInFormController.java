package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminSignInFormController {

    public TextField txtAdminFName;
    public AnchorPane subroot;
    public TextField txtAdminPW;
    public TextField txtAdminLName;
    public TextField txtAdminEmail;
    public Button btnAdminSignin;
    public Button btnAdminCrtAcc;


    public void btnAdminSigninOnAction(ActionEvent actionEvent) throws IOException {
        navigateToMainWindow();
        //adminDashboardFormController.initialize();

    }
    private void navigateToMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin_dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);

        subroot.getChildren().clear();
        Stage primaryStage = (Stage) subroot.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");

    }


    public void btnAdminCrtAccOnAction(ActionEvent actionEvent) {

    }
}
