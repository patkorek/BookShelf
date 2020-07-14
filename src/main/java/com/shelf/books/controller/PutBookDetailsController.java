package com.shelf.books.controller;

import com.shelf.books.model.BookDetails;
import com.shelf.books.service.BookCommentsService;
import com.shelf.books.service.BookDetailsService;
import com.shelf.books.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/shelf")
public class PutBookDetailsController {

    private final BookDetailsService bookDetailsService;
    private final BookValidator bookValidator;
    private final BookCommentsService bookCommentsService;

    @Autowired
    public PutBookDetailsController(BookDetailsService bookDetailsService, BookValidator bookValidator, BookCommentsService bookCommentsService) {
        this.bookDetailsService = bookDetailsService;
        this.bookValidator = bookValidator;
        this.bookCommentsService = bookCommentsService;
    }

    @PutMapping("/book")
    public ResponseEntity<BookDetails> updateBook(@RequestBody BookDetails bookDetails) throws ExecutionException, InterruptedException {
        Optional<BookDetails> optionalBook = bookDetailsService.findByAuthorAndTitle(bookDetails.getAuthor(), bookDetails.getTitle());
        if(optionalBook.isPresent()) {
            bookDetails.setId(optionalBook.get().getId());
        }
        bookValidator.validate(bookDetails);
        bookDetailsService.addBook(bookDetails);
        return ResponseEntity.ok(bookDetails);
    }
}
