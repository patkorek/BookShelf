package com.shelf.books.controller;

import com.shelf.books.model.BookComments;
import com.shelf.books.service.BookCommentsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class GetBookCommentsController {

    private final BookCommentsService bookCommentsService;

    public GetBookCommentsController(BookCommentsService bookCommentsService) {
        this.bookCommentsService = bookCommentsService;
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<Page<BookComments>> getAllComments(@PathVariable("page") int page, @PathVariable("size") int size) {
        return new ResponseEntity<>(bookCommentsService.getCommentsList(PageRequest.of(page, size)), HttpStatus.OK);
    }

}
