package com.shelf.books.repository;

import com.shelf.books.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetails, Long> {

    Optional<BookDetails> findByAuthorAndTitle(String author, String bookTitle);

    void deleteByAuthorAndTitle(String bookAuthor, String bookTitle);
}
