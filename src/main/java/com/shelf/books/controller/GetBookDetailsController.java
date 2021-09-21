package com.shelf.books.controller;

import com.shelf.books.dto.BookShelf;
import com.shelf.books.service.BookCommentService;
import com.shelf.books.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shelf")
public class GetBookDetailsController {

    private final BookDetailsService bookDetailsService;
    private final BookCommentService bookCommentService;

    @Autowired
    public GetBookDetailsController(BookDetailsService bookDetailsService, BookCommentService bookCommentService) {
        this.bookDetailsService = bookDetailsService;
        this.bookCommentService = bookCommentService;
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<BookShelf>> getAllBooks(@PathVariable("page") int page, @PathVariable("size") int size) {
        return new ResponseEntity<>(
                bookDetailsService.findAllBooks(PageRequest.of(page, size)).stream()
                        .map(bookDetails -> new BookShelf(bookDetails,
                                bookCommentService.getTop5BookComments(bookDetails.getAuthor(), bookDetails.getTitle())
                        )).collect(Collectors.toList()), HttpStatus.OK
        );
    }
}
