package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(Pageable pageable){
        return bookRepository.findAll(pageable).getContent();
    }

    public Optional<Book> getBooksById(Long id){
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        book.setPrice(bookDetails.getPrice());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublisher(bookDetails.getPublisher());
        return bookRepository.save(book);
    }

    public List<Book> findByAuthor(String authorName){
        return bookRepository.findByAuthorName(authorName);
    }

    public List<Book> findBooksByPublisher(String publisherName) {
        return bookRepository.findByPublisherName(publisherName);
    }

    public List<Book> findBooksByTitleKeyword(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    public List<Book> getBooksSortedByPrice(boolean ascending) {
        Sort sort = ascending ? Sort.by("price").ascending() : Sort.by("price").descending();
        return bookRepository.findAll(sort);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
