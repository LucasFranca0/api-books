package com.books.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity(name = "book_model")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 40)
    @NotBlank(message = "O título do livro é obrigatório")
    private String title;
    @Column(nullable = false, length = 50)
    @NotBlank(message = "O autor do livro é obrigatório")
    private String author;
    @Column(nullable = false, length = 4)
    @NotNull(message = "O ano de publicação é obrigatório")
    @PastOrPresent(message = "O ano de publicação deve ser no passado ou presente")
    private int publication_year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }
}
