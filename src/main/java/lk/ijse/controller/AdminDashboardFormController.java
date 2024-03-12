package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashboardFormController {
    public AnchorPane root;
    public Button BtnMngBooks;
    public Button btnMngBrnches;
    public Button btnTrnsctionHistry;
    public Button btnAdminAcc;
    public Label lblAdminName;

    public void initialize() throws IOException {
        initializeDashboard();
    }


    private void initializeDashboard() throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/manage_books_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }


    public void BtnMngBooksOnAction(ActionEvent actionEvent) throws IOException {
        initializeDashboard();
    }

    public void btnMngBrnchesOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/manage_branches_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnTrnsctionHistryOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/transaction_history_form.fxml"));
        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnAdminAccOnAction(ActionEvent actionEvent) {
    }
    public void setAdminName(String adminName) {
        lblAdminName.setText(adminName);
    }
}
