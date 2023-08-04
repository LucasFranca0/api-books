package com.books.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

public class BookDTO {
    @NotBlank(message = "O título do livro é obrigatório")
    private String title;
    @NotBlank(message = "O autor do livro é obrigatório")
    private String author;
    @NotNull(message = "O ano de publicação é obrigatório")
    @PastOrPresent(message = "O ano de publicação deve ser no passado ou presente")
    private int publication_year;

    public BookDTO(){}

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
