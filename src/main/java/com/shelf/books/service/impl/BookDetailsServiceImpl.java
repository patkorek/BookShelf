package com.shelf.books.service.impl;

import com.shelf.books.model.BookDetails;
import com.shelf.books.repository.BookDetailsRepository;
import com.shelf.books.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class BookDetailsServiceImpl implements BookDetailsService {

    private BookDetailsRepository bookDetailsRepository;

    @Autowired
    public BookDetailsServiceImpl(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    @Override
    public Optional<BookDetails> findByAuthorAndTitle(String author, String bookTitle) {
        return bookDetailsRepository.findByAuthorAndTitle(author, bookTitle);
    }

    @Override
    public Page<BookDetails> findAllBooks(Pageable pageable) {
        return bookDetailsRepository.findAll(pageable);
    }

    @Override
    public void addBook(BookDetails book) {
        bookDetailsRepository.save(book);
    }

    @Override
    public void removeBook(String bookAuthor, String bookTitle) {
        bookDetailsRepository.deleteByAuthorAndTitle(bookAuthor, bookTitle);
    }
}
