package com.shelf.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookComment {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    private String bookAuthor;

    private String bookTitle;

    private int rating;

    @CreationTimestamp
    private LocalDateTime commentAdded;
}
