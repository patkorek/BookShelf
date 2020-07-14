package com.shelf.books.service;

import com.shelf.books.model.BookComments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookCommentsService {

    Page<BookComments> getCommentsList(Pageable pageable);

    void addComment(BookComments bookComment);

    List<BookComments> getBookComments(Long bookId);

    void removeComment(Long id);
}
