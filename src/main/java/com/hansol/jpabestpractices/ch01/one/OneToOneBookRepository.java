package com.hansol.jpabestpractices.ch01.one;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToOneBookRepository extends JpaRepository<OneToOneBook, Long> {

    @Query("SELECT b FROM one_book b WHERE b.author = ?1")
    OneToOneBook fetchBookByAuthor(OneToOneAuthor author);
}
