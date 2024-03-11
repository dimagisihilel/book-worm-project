package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    @Column(nullable = false)
    private String branchName;
    private String address;
    private String contact;

    @ManyToOne
    private Admin admin;
    @OneToMany(mappedBy = "branch")
    private List<Book> books;

    public Branch() {
    }

    public Branch(int branchId, String branchName, String address, String contact, Admin admin, List<Book> books) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.address = address;
        this.contact = contact;
        this.admin = admin;
        this.books = books;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", admin=" + admin +
                ", books=" + books +
                '}';
    }

}
