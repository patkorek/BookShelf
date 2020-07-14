package com.shelf.books.controller;

import com.shelf.books.exception.ResourceException;
import com.shelf.books.service.BookCommentsService;
import com.shelf.books.service.BookDetailsService;
import com.shelf.books.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shelf")
public class DelBookDetailsController {

    private final BookDetailsService bookDetailsService;
    private final BookValidator bookValidator;
    private final BookCommentsService bookCommentsService;

    @Autowired
    public DelBookDetailsController(BookDetailsService bookDetailsService, BookValidator bookValidator, BookCommentsService bookCommentsService) {
        this.bookDetailsService = bookDetailsService;
        this.bookValidator = bookValidator;
        this.bookCommentsService = bookCommentsService;
    }

    @DeleteMapping("/book/{author}/{title}")
    public ResponseEntity deleteBookByName(@PathVariable(value = "author") String bookAuthor,
                                           @PathVariable(value = "title") String bookTitle) {
        if(bookDetailsService.findByAuthorAndTitle(bookAuthor, bookTitle).isPresent()) {
            bookDetailsService.removeBook(bookAuthor, bookTitle);
        } else {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Book with this author and title doesn't exist.");
        }
        return new ResponseEntity<>("Book removed.", HttpStatus.OK);
    }
}
