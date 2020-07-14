package com.shelf.books.repository;

import com.shelf.books.model.BookComments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCommentsRepository extends JpaRepository<BookComments, Long> {

    List<BookComments> findTop5ByBookIdOrderByIdDesc(Long bookId);
}
