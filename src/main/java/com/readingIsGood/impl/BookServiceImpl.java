package com.readingIsGood.impl;


import com.readingIsGood.entity.Book;
import com.readingIsGood.repository.BookRepository;
import com.readingIsGood.service.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<Book> updateBook(Long id, Book book) {
        if (Objects.isNull(id) || Objects.isNull(book.getId()) || !Objects.equals(id, book.getId()))
            return  ResponseEntity.badRequest().build();

        Optional<Book> checkBook = this.bookRepository.findById(id);
        if (checkBook.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(this.bookRepository.save(book));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Book createBook(Book book) {
        return this.bookRepository.save(book);
        // TODO: stock logic
    }
}
