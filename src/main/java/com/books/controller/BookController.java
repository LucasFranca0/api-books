package com.books.controller;

import com.books.dto.BookDTO;
import com.books.exception.BookNotFoundException;
import com.books.exception.ErrorResponse;
import com.books.exception.InvalidBookDataException;
import com.books.model.BookModel;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // Injeção de dependencia para fornecer uma instancia de service e podermos
    // acessar os métodos de manipulação de dados
    @Autowired
    private BookService bookService;

    // Requisições
    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable Long id) {
        BookModel book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookModel> createBook(@Valid @RequestBody BookDTO bookDTO) {
        BookModel createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDto) {
        BookModel updatedBook = bookService.updateBook(id, bookDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build(); // Resposta 204 No Content em caso de sucesso
    }

    @DeleteMapping()
    public void deleteAllBooks(){
        bookService.deleteAllBooks();
    }

    // Tratamento de exceções

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidBookDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookDataException(InvalidBookDataException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // Irá retornar status 500 e uma mensagem generica para exceções sem tratamento específico
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro interno no servidor.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
