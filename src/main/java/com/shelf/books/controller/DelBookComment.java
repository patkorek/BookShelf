package com.shelf.books.controller;

import com.shelf.books.exception.ResourceException;
import com.shelf.books.service.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class DelBookComment {

    private final BookCommentService bookCommentService;

    @Autowired
    public DelBookComment(BookCommentService bookCommentService) {
        this.bookCommentService = bookCommentService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookByName(@PathVariable(value = "id") Long id) {
        if(bookCommentService.findById(id).isPresent()) {
            bookCommentService.removeComment(id);
        } else {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Book comment with this id doesn't exist.");
        }
        return new ResponseEntity<>("Comment removed.", HttpStatus.OK);
    }
}
