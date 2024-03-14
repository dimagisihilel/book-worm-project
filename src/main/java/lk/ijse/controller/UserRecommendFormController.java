package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.BorrowBookRecordBo;
import lk.ijse.bo.custom.boImpl.BookBoImpl;
import lk.ijse.bo.custom.boImpl.BorrowBookRecordBoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.TransactionDto;
import lk.ijse.tm.BookTM;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UserRecommendFormController {


    public TableView<BookTM> tblRecomBooks;
    public TableColumn<BookTM,Integer> colBookId;
    public TableColumn<BookTM,String> colTitle;
    public TableColumn<BookTM,String> colAuthor;
    public TableColumn<BookTM,String> colGenre;
    public TableColumn<BookTM,String> colAvailability;
    public TextField txtSrchBooks;
    public ComboBox cmbCategory;
    public Label LblBookTitle;
    public Label lblCategory;
    public Button btnTakeBook;
    public Label lblAuthor;
    public DatePicker datePBorrowd;
    public DatePicker datePReturned;
    private int loggedUser;

    private BorrowBookRecordBo borrowBookRecordBo = new BorrowBookRecordBoImpl();

    BookBo bookBo = new BookBoImpl();

    public void initialize(){
        setCellValueFactory();
        setTableData();
    }

    private void setTableData() {
        List<BookDto> allBooks = bookBo.getAllBooks();
        ModelMapper mapper = new ModelMapper();
        ArrayList<BookTM> list = new ArrayList<>();

        for (BookDto bookDto : allBooks) {
            BookTM bookTM = mapper.map(bookDto, BookTM.class);
            list.add(bookTM);
        }
        System.out.println(list.size());

        tblRecomBooks.setItems(FXCollections.observableList(list));

    }

    public void setUserId(int userId){
        this.loggedUser = userId;
    }

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    public void btnTakeBookOnAction(ActionEvent actionEvent) {
        System.out.println("User Id : "+loggedUser);
        System.out.println("Borrow Date : "+datePBorrowd.getValue());
        System.out.println("Return Date : "+datePReturned.getValue());
        System.out.println("Book Id : "+tblRecomBooks.getSelectionModel().getSelectedItem().getBookId());
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setUserId(loggedUser);
        transactionDto.setBorrowedDate(datePBorrowd.getValue());
        transactionDto.setReturnedDate(datePReturned.getValue());
        transactionDto.setBookId(tblRecomBooks.getSelectionModel().getSelectedItem().getBookId());

        try {
            borrowBookRecordBo.borrowBook(transactionDto);
            new Alert(Alert.AlertType.INFORMATION, "Book borrowed successfully").show();
        }catch (Exception ex){
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }

    }

    public void tblOnMouseClicked(MouseEvent mouseEvent) {
        BookTM selectedItem = tblRecomBooks.getSelectionModel().getSelectedItem();
        if (selectedItem== null) return;
        if (selectedItem.getAvailability().equals("Not Available")){
            new Alert(Alert.AlertType.ERROR, "Book is not available").show();
            return;
        }
        LblBookTitle.setText(selectedItem.getTitle());
        lblAuthor.setText(selectedItem.getBookAuthor());
        lblCategory.setText(selectedItem.getCategory());
    }
}
