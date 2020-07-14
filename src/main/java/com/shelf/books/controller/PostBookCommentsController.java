package com.shelf.books.controller;

import com.shelf.books.model.BookComments;
import com.shelf.books.service.BookCommentsService;
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

    public PostBookCommentsController(BookCommentsService bookCommentsService) {
        this.bookCommentsService = bookCommentsService;
    }

    @PostMapping
    public ResponseEntity<BookComments> addComment(@RequestBody BookComments bookComments) {
        bookCommentsService.addComment(bookComments);
        return new ResponseEntity<>(bookComments, HttpStatus.CREATED);
    }
}
