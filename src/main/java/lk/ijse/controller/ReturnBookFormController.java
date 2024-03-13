package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReturnBookFormController {

    public TableView tblReturnBooks;
    public TableColumn colBookId;
    public TableColumn colBookName;
    public TableColumn colGenre;
    public TableColumn ColBorrowDate;
    public TableColumn colReturnDate;
    public Button btnReturn;

    public void btnReturnOnAction(ActionEvent actionEvent) {
    }
}
