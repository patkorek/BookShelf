package com.shelf.books.controller;

import com.shelf.books.exception.ResourceException;
import com.shelf.books.model.BookComment;
import com.shelf.books.service.BookCommentService;
import com.shelf.books.service.BookDetailsService;
import com.shelf.books.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class PostBookCommentController {

    private final BookCommentService bookCommentService;
    private final BookDetailsService bookDetailsService;
    private final CommentValidator commentValidator;

    @Autowired
    public PostBookCommentController(BookCommentService bookCommentService, BookDetailsService bookDetailsService,
                                     CommentValidator commentValidator) {
        this.bookCommentService = bookCommentService;
        this.bookDetailsService = bookDetailsService;
        this.commentValidator = commentValidator;
    }

    @PostMapping
    public ResponseEntity<BookComment> addComment(@RequestBody BookComment bookComment) {
        commentValidator.validateRating(bookComment.getRating());
        if(bookDetailsService.findByAuthorAndTitle(bookComment.getBookAuthor(), bookComment.getBookTitle()).isPresent()) {
            bookCommentService.addComment(bookComment);
        } else {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "This book doesn't exist");
        }
        return new ResponseEntity<>(bookComment, HttpStatus.CREATED);
    }
}
