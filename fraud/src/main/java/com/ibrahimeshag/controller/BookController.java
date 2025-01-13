package com.ibrahimeshag.controller;

import com.ibrahimeshag.model.Book;
import com.ibrahimeshag.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        try {
            List<Book> books = bookRepo.findAll();
            log.info("Getting all books");
            if (books.isEmpty()) {
                log.info("No books found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else
//                bookRepo.findAll().forEach(books::add);
                return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {

        Optional<Book> book = bookRepo.findById(id);

        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveBook(@RequestBody Book book) {

        try {
            bookRepo.save(book);
            return new ResponseEntity<String>("Book saved", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to save book", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @RequestBody Book book) {

        Optional<Book> opt = bookRepo.getBookById(id);

        if (opt.isPresent()) {
            Book book1 = opt.get();
            book1.setAuthor(book.getAuthor());
            book1.setName(book.getName());
            book1.setCost(book.getCost());
            return new ResponseEntity<>(bookRepo.save(book1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") String id) {

        try {
            bookRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllBooks() {

        try {
            bookRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}