package com.shelf.books.service.impl;

import com.shelf.books.model.BookComment;
import com.shelf.books.repository.BookCommentRepository;
import com.shelf.books.service.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookCommentServiceImpl implements BookCommentService {

    BookCommentRepository bookCommentRepository;

    @Autowired
    public BookCommentServiceImpl(BookCommentRepository bookCommentRepository) {
        this.bookCommentRepository = bookCommentRepository;
    }

    @Override
    public Page<BookComment> getCommentsList(Pageable pageable) {
        return bookCommentRepository.findAll(pageable);
    }

    @Override
    public void addComment(BookComment bookComment) {
        bookCommentRepository.save(bookComment);
    }

    @Override
    public List<BookComment> getTop5BookComments(String bookAuthor, String bookTitle) {
        return bookCommentRepository.findTop5ByBookAuthorAndBookTitleOrderByIdDesc(bookAuthor, bookTitle);
    }

    @Override
    public List<BookComment> getAllBookComments(Pageable pageable, String bookAuthor, String bookTitle) {
        return bookCommentRepository.findByBookAuthorAndBookTitle(pageable, bookAuthor, bookTitle);
    }

    @Override
    public Optional<BookComment> findById(Long id) {
        return bookCommentRepository.findById(id);
    }

    @Override
    @Async
    public void removeComment(Long id) {
        bookCommentRepository.deleteById(id);
    }
}
