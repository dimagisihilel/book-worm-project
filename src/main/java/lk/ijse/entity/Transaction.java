package lk.ijse.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;

    public Transaction() {
    }

    public Transaction(int id, User user, Book book, LocalDate borrowedDate, LocalDate returnedDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", borrowedDate=" + borrowedDate +
                ", returnedDate=" + returnedDate +
                '}';
    }
}
