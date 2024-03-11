package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WelcomeFormController {

    public AnchorPane root;

    public AnchorPane subRoot;
    public Button btnctnUser;
    public Button btnCtnAdmin;

    public void btnctnUserOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/user_login_form.fxml"));

        this.subRoot.getChildren().clear();
        this.subRoot.getChildren().add(node);

    }

    public void btnCtnAdminOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/admin_login_form.fxml"));

        this.subRoot.getChildren().clear();
        this.subRoot.getChildren().add(node);
    }
}
