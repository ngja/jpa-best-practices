package com.hansol.jpabestpractices.ch01.bidirectional;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;

@Transactional
@SpringBootTest
public class BidirectionalTest {

    private static final Logger log = LoggerFactory.getLogger(BidirectionalTest.class);

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Rollback(false)
    public void saveTest() {
        Book book1 = new Book(null, "isbn01", "title01", null);
        Book book2 = new Book(null, "isbn02", "title02", null);

        Author author1 = new Author(null, 20, "SF", "hansol", new ArrayList<>());

        author1.addBook(book1);
        author1.addBook(book2);

        entityManager.persist(author1);

        log.info("book1 = {}, book2 = {}", book1, book2);
        log.info("author1 = {}", author1);
    }

    @Test
    public void readTest() {

        Author author = authorRepository.findById(3L).orElseThrow();

        log.info("author = {}", author);

        Book book = bookRepository.findById(5L).orElseThrow();

        log.info("book = {}", book);


        log.info("author's books = {}", author.getBooks());
        log.info("book's author = {}", book.getAuthor());
    }
}
