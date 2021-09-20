package com.shelf.books.validator;

import com.shelf.books.exception.ResourceException;
import com.shelf.books.model.BookDetails;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class BookValidator {

    public void validateBookDetails(BookDetails book) {
        validateISBN(book.getIsbn());
        validateFields(book);

    }

    private void validateFields(BookDetails book) {
        if(book.getAuthor().isEmpty() || book.getTitle().isEmpty()) {
            throw new ResourceException("Author or title field is empty.");
        }
    }


    private void validateISBN(String isbn) {
        String isbnRegex = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
        Pattern pattern = Pattern.compile(isbnRegex);
        if(!pattern.matcher(isbn).matches()) {
            throw new ResourceException("ISBN code is incorrect.");
        }
    }
}
