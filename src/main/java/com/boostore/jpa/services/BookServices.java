package com.boostore.jpa.services;

import com.boostore.jpa.dtos.BookRecordDto;
import com.boostore.jpa.models.BookModel;
import com.boostore.jpa.models.ReviewModel;
import com.boostore.jpa.repository.AuthorRepository;
import com.boostore.jpa.repository.BookRepository;
import com.boostore.jpa.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public BookModel saveBook(BookRecordDto bookDto) {
        BookModel book = new BookModel();
        book.setTitle(bookDto.title());
        book.setPublisher(publisherRepository.findById(bookDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookDto.reviewComent());
        reviewModel.setBook(book);
        book.setReview(reviewModel);
        return bookRepository.save(book);
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
