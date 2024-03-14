package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.BorrowBookRecordBo;
import lk.ijse.bo.custom.boImpl.BorrowBookRecordBoImpl;
import lk.ijse.tm.NotReturnedTM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ReturnBookFormController {

    public TableView<NotReturnedTM> tblReturnBooks;
    public TableColumn<NotReturnedTM, Integer> colBookId;
    public TableColumn<NotReturnedTM, String> colBookName;
    public TableColumn<NotReturnedTM, String> colGenre;
    public TableColumn<NotReturnedTM, LocalDate> ColBorrowDate;
    public TableColumn<NotReturnedTM, LocalDate> colReturnDate;
    public Button btnReturn;
    private BorrowBookRecordBo borrowBookRecordBo = new BorrowBookRecordBoImpl();
    private int userId;

    public void btnReturnOnAction(ActionEvent actionEvent) {
        NotReturnedTM selectedItem = tblReturnBooks.getSelectionModel().getSelectedItem();
        if (selectedItem==null)return;
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO).showAndWait();
        if (buttonType.isPresent() && buttonType.get() == ButtonType.YES){
            borrowBookRecordBo.returnBook(selectedItem);
            loadTableData();
        }
    }

    public void setUserId(int userId) {
        this.userId = userId;
        setCellValueFactories();
        loadTableData();
    }

    public void setCellValueFactories(){
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("category"));
        ColBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
    }

    public void loadTableData(){
        List<NotReturnedTM> notReturnedListByUserId = borrowBookRecordBo.getNotReturnedListByUserId(userId);
        tblReturnBooks.setItems(FXCollections.observableArrayList(notReturnedListByUserId));
    }


}
