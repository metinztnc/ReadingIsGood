package com.readingIsGood.repository;


import com.readingIsGood.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseJpaRepository<Book,Long> {
}
