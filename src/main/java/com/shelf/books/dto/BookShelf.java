package com.shelf.books.dto;

import com.shelf.books.model.BookComment;
import com.shelf.books.model.BookDetails;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookShelf {

    private BookDetails bookDetails;
    private List<BookComment> bookComment;
}
