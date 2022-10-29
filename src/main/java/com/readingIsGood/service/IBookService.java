package com.readingIsGood.service;

import com.readingIsGood.entity.Book;
import org.springframework.http.ResponseEntity;

public interface IBookService {

    ResponseEntity<Book> updateBook(Long id, Book book);

    Book createBook(Book book);
}
