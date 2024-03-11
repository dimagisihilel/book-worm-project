package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class UserRecommendFormController {

    public TableView tblRecomBooks;
    public TableColumn colBookId;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colGenre;
    public TableColumn colAvailability;
    public TextField txtSrchBooks;
    public ComboBox cmbCategory;
    public Label LblBookTitle;
    public Label lblCategory;
    public Button btnTakeBook;
    public Label lblAuthor;
    public DatePicker datePBorrowd;
    public DatePicker datePReturned;

    public void btnTakeBookOnAction(ActionEvent actionEvent) {

    }
}
