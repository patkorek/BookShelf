package com.shelf.books.service;

import com.shelf.books.model.BookComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookCommentService {

    Page<BookComment> getCommentsList(Pageable pageable);

    void addComment(BookComment bookComment);

    List<BookComment> getTop5BookComments(String bookAuthor, String bookTitle);

    List<BookComment> getAllBookComments(Pageable pageable, String bookAuthor, String bookTitle);

    Optional<BookComment> findById(Long id);

    void removeComment(Long id);
}
