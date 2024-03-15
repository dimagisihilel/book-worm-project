package lk.ijse.tm;

import java.time.LocalDate;

public class UserFineTM {
    private String Username;
    private String title;
    private String email;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    private LocalDate dueDateCount;
    private double fine;

    public UserFineTM(String username, String title, String email, LocalDate borrowedDate, LocalDate returnedDate, LocalDate dueDateCount, double fine) {
        Username = username;
        this.title = title;
        this.email = email;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.dueDateCount = dueDateCount;
        this.fine = fine;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getDueDateCount() {
        return dueDateCount;
    }

    public void setDueDateCount(LocalDate dueDateCount) {
        this.dueDateCount = dueDateCount;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
