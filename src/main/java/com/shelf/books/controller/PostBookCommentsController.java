package com.shelf.books.controller;

import com.shelf.books.model.BookComments;
import com.shelf.books.service.BookCommentsService;
import com.shelf.books.validator.CommentsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class PostBookCommentsController {

    private final BookCommentsService bookCommentsService;
    private final CommentsValidator commentsValidator;

    @Autowired
    public PostBookCommentsController(BookCommentsService bookCommentsService, CommentsValidator commentsValidator) {
        this.bookCommentsService = bookCommentsService;
        this.commentsValidator = commentsValidator;
    }

    @PostMapping
    public ResponseEntity<BookComments> addComment(@RequestBody BookComments bookComments) {
        commentsValidator.validateRating(bookComments.getRating());
        bookCommentsService.addComment(bookComments);
        return new ResponseEntity<>(bookComments, HttpStatus.CREATED);
    }
}
