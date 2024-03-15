package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.bo.custom.boImpl.BookBoImpl;
import lk.ijse.bo.custom.boImpl.BranchBoImpl;
import lk.ijse.cm.BranchCM;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dao.custom.daoImpl.BranchDaoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;
import lk.ijse.tm.BookTM;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageBooksFormController {

    public TextField txtBTitle;
    public TextField txtAuthor;
    public TextField txtGenre;
    public TextField txtNoOfCopies;
    public TextField txtAvailability;
    public ComboBox<BranchCM> cmbBranch;
    public Button btnAddBook;
    public Button btnUpdateBook;
    public Button btnDeleteBook;
    public TableView<BookTM> tblBooks;
    public TableColumn<BookTM,String> colBookName;
    public TableColumn<BookTM,String> colBookAuthor;
    public TableColumn<BookTM,String> colTotalCopies;
    public TableColumn<BookTM,String> colAvailability;

    BranchBo branchBo = new BranchBoImpl();
    BookBo bookBo = new BookBoImpl();

    public void initialize(){
        setConverter();
        setComboBoxData();
        setCellValueFactory();
        setTableData();
    }

    public void setCellValueFactory(){
        colBookName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colTotalCopies.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    public void setTableData(){
        ModelMapper mapper = new ModelMapper();
        ArrayList<BookTM> list = new ArrayList<>();
        try {
            List<BookDto> allBooks = bookBo.getAllBooks();
            for (BookDto book : allBooks) {
                BookTM map = mapper.map(book, BookTM.class);
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblBooks.setItems(FXCollections.observableArrayList(list));
    }


    public void setComboBoxData(){
        ModelMapper mapper = new ModelMapper();
        ArrayList<BranchCM> list = new ArrayList<>();
        try {
            List<BranchDto> allBranches = branchBo.getAllBranches();
            for (BranchDto branch : allBranches) {
                BranchCM map = mapper.map(branch, BranchCM.class);
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cmbBranch.setItems(FXCollections.observableArrayList(list));
    }

    public void setConverter(){
        cmbBranch.setConverter(new StringConverter<BranchCM>() {
            @Override
            public String toString(BranchCM branchCM) {
                if (branchCM == null) {
                    return null;
                }
                return String.format("%02d - %s", branchCM.getBranchId(), branchCM.getBranchName());
            }

            @Override
            public BranchCM fromString(String s) {
                return null;
            }
        });
    }

    public void cmbBranchOnAction(ActionEvent actionEvent) {
    }

    public void btnAddBookOnAction(ActionEvent actionEvent) {
        BookDto bookDto = collectData();
        bookDto.setBookId(0);
        try {
            bookBo.addBook(bookDto);
            new Alert(Alert.AlertType.INFORMATION, "Book Added Successfully").show();
            clearTextFields();
            setTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnUpdateBookOnAction(ActionEvent actionEvent) {
        BookDto bookDto = collectData();
        try {
            bookBo.updateBook(bookDto);
            new Alert(Alert.AlertType.INFORMATION, "Book Updated Successfully").show();
            clearTextFields();
            setTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnDeleteBookOnAction(ActionEvent actionEvent) {
        BookDto bookDto = collectData();
        try {
            bookBo.deleteBook(bookDto.getBookId());
            new Alert(Alert.AlertType.INFORMATION, "Book Deleted Successfully").show();
            setTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public BookDto collectData(){
        BookDto bookDto = new BookDto();
        BookTM selectedItem = tblBooks.getSelectionModel().getSelectedItem();
        bookDto.setBookId(selectedItem == null ? 0 : selectedItem.getBookId());
        bookDto.setTitle(txtBTitle.getText());
        bookDto.setAuthor(txtAuthor.getText());
        bookDto.setCategory(txtGenre.getText());
        //bookDto.set(Integer.parseInt(txtNoOfCopies.getText()));
        bookDto.setAvailability(txtAvailability.getText());
        bookDto.setBranchId(cmbBranch.getSelectionModel().getSelectedItem().getBranchId());
        return bookDto;
    }

    public void tblBookOnMouseClicked(MouseEvent mouseEvent) {
        BookTM selectedItem = tblBooks.getSelectionModel().getSelectedItem();
        if (selectedItem==null)return;
         txtBTitle.setText(selectedItem.getTitle());
         txtAuthor.setText(selectedItem.getBookAuthor());
         txtGenre.setText(selectedItem.getCategory());
         txtAvailability.setText(selectedItem.getAvailability());

        System.out.println(selectedItem.getBookId());
        for (BranchCM item : cmbBranch.getItems()) {
            if (item.getBranchId() == selectedItem.getBranchId()) {
                cmbBranch.getSelectionModel().select(item);
                break;
            }
        }
    }
    private void clearTextFields() {
        txtBTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
        cmbBranch.getSelectionModel().clearSelection();
        txtAvailability.setText("");
    }

    public void txtBTitleOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtAuthorOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtGenreOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtAvailabilityOnKeyReleased(KeyEvent keyEvent) {
    }
}
