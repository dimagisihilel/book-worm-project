package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    public void initialize() throws IOException {
        paneAccSetting.setVisible(false);
        initializeDashboard();
    }

    private void initializeDashboard() throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/user_recommend_form.fxml"));

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
}
