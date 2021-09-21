package com.shelf.books.repository;

import com.shelf.books.model.BookComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {

    List<BookComment> findTop5ByBookAuthorAndBookTitleOrderByIdDesc(String bookAuthor, String bookTitle);

    List<BookComment> findByBookAuthorAndBookTitle(Pageable pageable, String bookAuthor, String bookTitle);

    Optional<BookComment> findById(Long id);
}
