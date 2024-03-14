package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.bo.custom.boImpl.AdminBoImpl;
import lk.ijse.bo.custom.boImpl.UserBoImpl;

import java.io.IOException;

public class UserDashboardFormController {

    public AnchorPane root;
    public Pane paneAccSetting;
    public Button btnEditpro;
    public Button btnLogout;
    public Button btnRecommend;
    public Button btnRead;
    public Button btnAccount;
    public Button btnDltAcc;
    public Label lblUserName;
    public Button btnReturnBooks;
    private UserBo userBo = new UserBoImpl();
    private int activeUserId;

    public void initialize() throws IOException {
        paneAccSetting.setVisible(false);

    }

    private void initializeDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/user_recommend_form.fxml"));
        Parent node = loader.load();
        UserRecommendFormController controller = loader.getController();
        controller.setUserId(activeUserId);

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnAccountOnAction(ActionEvent actionEvent) {
        // Check if the pane is currently visible
        if (paneAccSetting.isVisible()) {
            // If visible, hide the pane
            paneAccSetting.setVisible(false);
        } else {
            // If not visible, show the pane
            paneAccSetting.setVisible(true);
        }

    }

    public void btnReadOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/user_history_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnRecommendOnAction(ActionEvent actionEvent) throws IOException {
        initializeDashboard();
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnEditproOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user_account_form.fxml"));
        Parent parent = loader.load();
        UserAccountFormController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(new Scene(parent));

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(btnAccount.getScene().getWindow());
        stage.show();

    }

    public void btnDltAccOnAction(ActionEvent actionEvent) {

    }
    public void setUserName(String userName) throws IOException {
        lblUserName.setText(userName);
        initializeDashboard();
    }

    public void setUserId(int userId) {
        activeUserId = userId;
    }

    public void btnReturnBooksOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new  FXMLLoader(this.getClass().getResource("/view/return_book_form.fxml"));
        Parent node = loader.load();

        ReturnBookFormController controller = loader.getController();
        controller.setUserId(activeUserId);
        this.root.getChildren().clear();
        this.root.getChildren().add(node);

    }
}
