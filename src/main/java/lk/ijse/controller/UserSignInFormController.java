package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserSignInFormController {

    public Button btnUSignIn;
    public TextField txtUserEmail;
    public TextField txtuserLName;
    public TextField txtUserFName;
    public AnchorPane subroot;
    public TextField txtUserPW;

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

    }

    public void txtUserFNameOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtUserLNameOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtUserEmailOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtUserPWOnKeyReleased(KeyEvent keyEvent) {
    }
}
