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
import lk.ijse.bo.custom.UserBo;
import lk.ijse.bo.custom.boImpl.AdminBoImpl;
import lk.ijse.bo.custom.boImpl.UserBoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;
import lk.ijse.util.Regex;
import lk.ijse.util.TextFields;

import java.io.IOException;

public class UserLoginFormController {
    public Button btnUserLogIn;
    public Button btnUserSignIn;
    public AnchorPane subroot;
    public TextField txtUserEmail;
    public TextField txtUserPW;

    private UserBo userBo = new UserBoImpl();

    public void btnUserSignInOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/user_signin_form.fxml"));

        this.subroot.getChildren().clear();
        this.subroot.getChildren().add(node);
    }

    public void btnUserLogInOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtUserEmail.getText();
        String password = txtUserPW.getText();

        try {
            UserDto userDto = userBo.loginUser(email, password);
            if (userDto != null) {
                // navigateToMainWindow();
                openUserDashboard(userDto.getUserId(),userDto.getFirstName() + " " + userDto.getLastName());
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
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);

        subroot.getChildren().clear();
        Stage primaryStage = (Stage) subroot.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");

    }*/

    private void openUserDashboard(int userId,String userName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user_dashboard_form.fxml"));
        Parent rootNode = loader.load();

        // Pass user name and id to the dashboard controller
        UserDashboardFormController controller = loader.getController();
        controller.setUserId(userId);
        controller.setUserName(userName);

        Scene scene = new Scene(rootNode);

        Stage primaryStage = (Stage) subroot.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");
    }

    public void txtUserEmailOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.EMAIL,txtUserEmail);
    }

    public void txtUserPWOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PASSWORD,txtUserPW);
    }
}
