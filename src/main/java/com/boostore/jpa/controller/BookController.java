package com.boostore.jpa.controller;

import com.boostore.jpa.dtos.BookRecordDto;
import com.boostore.jpa.models.BookModel;
import com.boostore.jpa.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStore/books")
public class BookController {
    @Autowired
    private BookServices bookServices;

    @GetMapping
    public ResponseEntity<List<BookModel>> allBooks() {
    return  ResponseEntity.status(HttpStatus.CREATED).body(bookServices.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookServices.saveBook(bookDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookServices.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfuly");
    }
}
