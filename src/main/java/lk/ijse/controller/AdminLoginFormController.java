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

public class AdminLoginFormController {

    public AnchorPane subroot;
    public Button btnAdminLogIn;
    public Button btnAdminSignIn;
    public TextField txtALoginEmail;
    public TextField txtALoginPW;

    public void btnAdminSignInOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/admin_signin_form.fxml"));

        this.subroot.getChildren().clear();
        this.subroot.getChildren().add(node);
    }

    public void btnAdminLogInOnAction(ActionEvent actionEvent) throws IOException {
        navigateToMainWindow();

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
}
