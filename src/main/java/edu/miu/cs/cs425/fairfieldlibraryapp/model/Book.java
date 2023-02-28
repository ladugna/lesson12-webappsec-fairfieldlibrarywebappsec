package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
@NamedQuery(name="Book.getCheapBooks", query = "select b from Book b where b.costPrice.amount < 10")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(unique = true, nullable = false)
    private String isbn;

    @NotBlank(message = "Book title must not be blank or empty or null")
    @Column(nullable = false)
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePublished;
    private Integer numOfCopies;

    @Embedded
    private Money costPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;

    @Override
    public String toString() {
        return String.format("Book{bookId: %d, isbn: %s, title: %s}", bookId, isbn, title);
    }
}
