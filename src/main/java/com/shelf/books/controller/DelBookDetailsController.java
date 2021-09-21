package com.shelf.books.controller;

import com.shelf.books.exception.ResourceException;
import com.shelf.books.model.BookComment;
import com.shelf.books.service.BookCommentService;
import com.shelf.books.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    private final BookCommentService bookCommentService;

    @Autowired
    public DelBookDetailsController(BookDetailsService bookDetailsService, BookCommentService bookCommentService) {
        this.bookDetailsService = bookDetailsService;
        this.bookCommentService = bookCommentService;
    }

    @DeleteMapping("/book/{author}/{title}")
    public ResponseEntity<String> deleteBookByName(@PathVariable(value = "author") String bookAuthor,
                                                        @PathVariable(value = "title") String bookTitle) {
        if(bookDetailsService.findByAuthorAndTitle(bookAuthor, bookTitle).isPresent()) {
            bookCommentService.getAllBookComments(Pageable.unpaged(), bookAuthor, bookTitle)
                    .forEach(bookComments -> bookCommentService.removeComment(bookComments.getId()));
            bookDetailsService.removeBook(bookAuthor, bookTitle);
        } else {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Book with this author and title doesn't exist.");
        }
        return new ResponseEntity<>("Book removed.", HttpStatus.OK);
    }
}
