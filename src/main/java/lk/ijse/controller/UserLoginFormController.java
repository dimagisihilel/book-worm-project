package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginFormController {
    public Button btnUserLogIn;
    public Button btnUserSignIn;
    public AnchorPane subroot;

    public void btnUserSignInOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/user_signin_form.fxml"));

        this.subroot.getChildren().clear();
        this.subroot.getChildren().add(node);
    }

    public void btnUserLogInOnAction(ActionEvent actionEvent) throws IOException {
        navigateToMainWindow();

    }
    private void navigateToMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);

        subroot.getChildren().clear();
        Stage primaryStage = (Stage) subroot.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");

    }
}
