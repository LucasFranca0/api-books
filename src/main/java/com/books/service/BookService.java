package com.books.service;

import com.books.dto.BookDTO;
import com.books.exception.BookNotFoundException;
import com.books.exception.InvalidBookDataException;
import com.books.model.BookModel;
import com.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookModel getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Livro não encontrado com o ID: " + id));
    }

    public BookModel createBook(BookDTO bookDTO) {
        // Realize todas as validações necessárias no DTO
        if (bookDTO.getTitle().trim().isEmpty() || bookDTO.getAuthor().trim().isEmpty()) {
            throw new InvalidBookDataException("Título e autor do livro são obrigatórios.");
        }

        BookModel book = new BookModel();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublication_year(bookDTO.getPublication_year());

        return bookRepository.save(book);
    }

    public BookModel updateBook(Long id, BookDTO bookDTO) {
        // Verificar se o livro existe antes de atualizar
        BookModel book = getBookById(id);

        if(bookDTO.getTitle().trim().isEmpty() || bookDTO.getAuthor().trim().isEmpty()) {
            throw new InvalidBookDataException("Título e autor do livro são obrigatórios.");
        }

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublication_year(bookDTO.getPublication_year());

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        // Verificar se o livro existe antes de excluir
        getBookById(id);
        if (getBookById(id) != null) {
            bookRepository.deleteById(id);
            return;
        }
        throw new BookNotFoundException("Livro não existe! Informe um livro existente.");
    }

    public List<BookModel> findAll(){
        return bookRepository.findAll();
    }

    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }
}