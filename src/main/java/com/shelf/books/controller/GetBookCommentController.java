package com.shelf.books.controller;

import com.shelf.books.model.BookComment;
import com.shelf.books.service.BookCommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class GetBookCommentController {

    private final BookCommentService bookCommentService;

    public GetBookCommentController(BookCommentService bookCommentService) {
        this.bookCommentService = bookCommentService;
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<Page<BookComment>> getAllComments(@PathVariable("page") int page, @PathVariable("size") int size) {
        return new ResponseEntity<>(bookCommentService.getCommentsList(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @GetMapping("/{page}/{size}/{bookAuthor}/{bookTitle}")
    public ResponseEntity<List<BookComment>> getAllBookComments(@PathVariable("page") int page, @PathVariable("size") int size,
                                                                @PathVariable("bookAuthor") String bookAuthor,
                                                                @PathVariable("bookTitle") String bookTitle) {
        return new ResponseEntity<>(bookCommentService.getAllBookComments(PageRequest.of(page, size), bookAuthor, bookTitle), HttpStatus.OK);
    }

}
