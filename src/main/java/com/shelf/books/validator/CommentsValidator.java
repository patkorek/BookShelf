package com.shelf.books.validator;

import com.shelf.books.exception.ResourceException;
import org.springframework.stereotype.Component;

@Component
public class CommentsValidator {

    public void validateRating(int rating) {
        if(rating > 6 || rating < 1) {
            throw new ResourceException("Rating value is incorrect, value should be between 1 and 6.");
        }
    }
}
