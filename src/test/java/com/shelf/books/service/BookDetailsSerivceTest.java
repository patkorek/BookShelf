package com.shelf.books.service;

import com.shelf.books.repository.BookDetailsRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookDetailsSerivceTest {

    @Mock
    BookDetailsRepository bookDetailsRepository;

    @InjectMocks
    BookDetailsService bookDetailsService;

}
