package com.shelf.books.service;

import com.shelf.books.model.BookDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookDetailsService {

    Optional<BookDetails> findByAuthorAndTitle(String author, String bookTitle);

    Page<BookDetails> findAllBooks(Pageable pageable);

    void addBook(BookDetails book);

    void removeBook(String bookAuthor, String bookTitle);
}
