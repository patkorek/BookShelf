package com.shelf.books.service.impl;

import com.shelf.books.model.BookComments;
import com.shelf.books.repository.BookCommentsRepository;
import com.shelf.books.service.BookCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookCommentsServiceImpl implements BookCommentsService {

    BookCommentsRepository bookCommentsRepository;

    @Autowired
    public BookCommentsServiceImpl(BookCommentsRepository bookCommentsRepository) {
        this.bookCommentsRepository = bookCommentsRepository;
    }

    @Override
    public Page<BookComments> getCommentsList(Pageable pageable) {
        return bookCommentsRepository.findAll(pageable);
    }

    @Override
    public void addComment(BookComments bookComment) {
        bookCommentsRepository.save(bookComment);
    }

    @Override
    public List<BookComments> getBookComments(Long bookId) {
        return bookCommentsRepository.findTop5ByBookIdOrderByIdDesc(bookId);
    }

    @Override
    @Async
    public void removeComment(Long id) {
        bookCommentsRepository.deleteById(id);
    }
}
