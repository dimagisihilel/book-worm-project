package lk.ijse.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.TransactionBo;
import lk.ijse.bo.custom.boImpl.TransactionBoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.TransactionDto;
import lk.ijse.dto.UserDto;
import lk.ijse.tm.UserFineTM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class NotReturnedUsersFormController {
    public TableView<UserFineTM> tblNotReturned;
    public TableColumn<UserFineTM, String> colUserName;
    public TableColumn<UserFineTM, String> colBookName;
    public TableColumn<UserFineTM, String> colUserEmail;
    public TableColumn<UserFineTM, LocalDate> colBorrowDate;
    public TableColumn<UserFineTM, LocalDate> colReturnDate;
    public TableColumn<UserFineTM, LocalDate> colDueDateCount;
    public TableColumn<UserFineTM, Double>colFine;

    private TransactionBo transactionBo = new TransactionBoImpl();

    public void initialize() {
        setCellValueFactory();
       // loadDataToTable();
    }

    private void setCellValueFactory() {
        colUserName.setCellValueFactory(new PropertyValueFactory<>("Username"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colUserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        colDueDateCount.setCellValueFactory(new PropertyValueFactory<>("dueDateCount"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
    }

    /*private void loadDataToTable() {
        try {
            List<TransactionDto> notReturnedTransactions = transactionBo.getNotReturnedTransactions();
            ObservableList<UserFineTM> data = FXCollections.observableArrayList();
            for (TransactionDto transaction : notReturnedTransactions) {
                // Access user and book details from the transaction
                UserDto userDto = transaction.getUser();
                BookDto bookDto = transaction.getBook();

                // Create UserFineTM object with relevant details
                data.add(new UserFineTM(
                        userDto.getUsername(),
                        bookDto.getTitle(),
                        userDto.getEmail(),
                        transaction.getBorrowedDate(),
                        transaction.getReturnedDate(),
                        transaction.getDueDateCount(),
                        transaction.getFine()
                ));
            }
            tblNotReturned.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
