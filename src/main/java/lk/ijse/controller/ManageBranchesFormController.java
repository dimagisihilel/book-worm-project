package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.bo.custom.boImpl.AdminBoImpl;
import lk.ijse.bo.custom.boImpl.BranchBoImpl;
import lk.ijse.dto.BranchDto;
import lk.ijse.util.Regex;
import lk.ijse.util.TextFields;

import java.sql.SQLException;

public class ManageBranchesFormController {


    public TableView tblbranches;
    public TableColumn colBranchName;
    public TableColumn colBranchAddress;
    public TableColumn colBranchContact;
    public TextField txtBranchName;
    public TextField txtBranchContact;
    public TextField txtBranchAddress;
    public Button btnAddbranch;
    public Button btnUpdatebranch;
    public Button btnDltbranch;



    private BranchBo branchBo = new BranchBoImpl();

    // Method to set the active admin ID
    public void setActiveAdminId(int adminId) {
        this.activeAdminId = adminId;
    }
    private int activeAdminId;

   public void btnAddbranchOnAction(ActionEvent actionEvent) {
        if (!validate()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields with valid data").show();
            return;
        }
        BranchDto branchDto = collectData();
       // Set the admin ID for the branch
       branchDto.setAdminId(activeAdminId);
        try {
            System.out.println("Adding a branch...");
            branchBo.addBranch(branchDto);
            new Alert(Alert.AlertType.INFORMATION, "Branch added successfully").show();
            clearTextFields();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to add branch: " + e.getMessage()).show();
            e.printStackTrace();
        }
   }

    public void btnUpdatebranchOnAction(ActionEvent actionEvent) {
    }

    public void btnDltbranchOnAction(ActionEvent actionEvent) {

    }

    public void txtBranchNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtBranchName);
    }

    public void txtBranchContactOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PHONE,txtBranchContact);
    }

    public void txtBranchAddressOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.ADDRESS,txtBranchAddress);
    }
    private BranchDto collectData() {
        BranchDto branchDto = new BranchDto();
        branchDto.setBranchName(txtBranchName.getText());
        branchDto.setBranchAddress(txtBranchAddress.getText());
        branchDto.setBranchContact(txtBranchContact.getText());

        System.out.println("Creating a branch...");
        System.out.println("branch Name: " + txtBranchName.getText());
        System.out.println("address: " + txtBranchAddress.getText());
        System.out.println("contact: " + txtBranchContact.getText());
        return branchDto;
    }
    public boolean validate() {
        return  Regex.isTextFieldValid(TextFields.NAME,txtBranchName.getText()) &&
                Regex.isTextFieldValid(TextFields.ADDRESS,txtBranchAddress.getText()) &&
                Regex.isTextFieldValid(TextFields.PHONE,txtBranchContact.getText());

    }

    private void clearTextFields() {
        txtBranchName.clear();
        txtBranchAddress.clear();
        txtBranchContact.clear();
    }

}
