package com.hansol.jpabestpractices.ch01.one;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@Transactional
@SpringBootTest
public class OneToOneTest {

    @Autowired
    private OneToOneAuthorRepository oneToOneAuthorRepository;

    @Autowired
    private OneToOneBookRepository oneToOneBookRepository;

    @Test
    @Rollback(false)
    public void insert() {
        OneToOneAuthor author = new OneToOneAuthor();
        author.setName("John");
        author.setAge(30);
        author.setGenre("A");
        oneToOneAuthorRepository.save(author);
    }

    @Test
    public void oneToOneTest() {

        OneToOneAuthor author = oneToOneAuthorRepository.findById(1L).orElseThrow();

        OneToOneBook book = new OneToOneBook();
        book.setTitle("A History of Ancient Prague");
        book.setIsbn("001-JN");
        book.setAuthor(author);

        oneToOneBookRepository.save(book);
    }

    @Test
    public void fetchBookByAuthorTest() {
        OneToOneAuthor author = oneToOneAuthorRepository.findById(1L).orElseThrow();

        OneToOneBook oneToOneBook = oneToOneBookRepository.fetchBookByAuthor(author);
    }
}
