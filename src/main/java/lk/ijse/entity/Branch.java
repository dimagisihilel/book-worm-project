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
}
