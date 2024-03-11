package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String category;
    private String availability;

    @ManyToOne
    private Branch branch;

    @ManyToMany(mappedBy = "bookList",cascade = CascadeType.ALL)
    private List<User> userList;
}
