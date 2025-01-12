package com.hansol.jpabestpractices.ch01.unidirectional;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class UnidirectionalTest {

    private static final Logger log = LoggerFactory.getLogger(UnidirectionalTest.class);

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UnidirectionalAuthorRepository unidirectionalAuthorRepository;

    @Autowired
    private UnidirectionalBookRepository unidirectionalBookRepository;

    @Test
    public void insertNewBook() {
        /*
         * getReferenceById() 를 이용해서 참조 반환으로 불필요한 select 문 피하기
         */
        UnidirectionalAuthor unidirectionalAuthor = unidirectionalAuthorRepository.getReferenceById(3L);

        UnidirectionalBook unidirectionalBook = new UnidirectionalBook();
        unidirectionalBook.setAuthor(unidirectionalAuthor);
        unidirectionalBook.setIsbn("isbn003");
        unidirectionalBook.setTitle("Java Best Practices");

        unidirectionalBookRepository.save(unidirectionalBook);
    }
}
