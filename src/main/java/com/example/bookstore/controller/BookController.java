package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        return bookService.getBooksById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String authorName) {
        List<Book> books = bookService.findByAuthor(authorName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/publisher/{publisherName}")
    public ResponseEntity<List<Book>> findBooksByPublisher(@PathVariable String publisherName) {
        List<Book> books = bookService.findBooksByPublisher(publisherName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String keyword) {
        List<Book> books = bookService.findBooksByTitleKeyword(keyword);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Book>> getBooksSortedByPrice(@RequestParam boolean ascending) {
        List<Book> books = bookService.getBooksSortedByPrice(ascending);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
