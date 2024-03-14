package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.boImpl.BookBoImpl;
import lk.ijse.dto.BookDto;
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

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    public void btnTakeBookOnAction(ActionEvent actionEvent) {

    }
}
