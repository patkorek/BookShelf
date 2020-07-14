package com.shelf.books.controller;

import com.shelf.books.exception.ResourceException;
import com.shelf.books.model.BookDetails;
import com.shelf.books.service.BookCommentsService;
import com.shelf.books.service.BookDetailsService;
import com.shelf.books.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/shelf")
public class PostBookDetailsController {

    private final BookDetailsService bookDetailsService;
    private final BookValidator bookValidator;
    private final BookCommentsService bookCommentsService;

    @Autowired
    public PostBookDetailsController(BookDetailsService bookDetailsService, BookValidator bookValidator, BookCommentsService bookCommentsService) {
        this.bookDetailsService = bookDetailsService;
        this.bookValidator = bookValidator;
        this.bookCommentsService = bookCommentsService;
    }

    @PostMapping("/book")
    public ResponseEntity<BookDetails> addBook(@RequestBody BookDetails bookDetails) throws ExecutionException, InterruptedException {
        bookValidator.validate(bookDetails);
        if(bookDetailsService.findByAuthorAndTitle(bookDetails.getAuthor(), bookDetails.getTitle()).isPresent()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Book with this author and title already exist.");
        } else {
            bookDetailsService.addBook(bookDetails);
        }
        return new ResponseEntity<>(bookDetails, HttpStatus.CREATED);
    }
}
