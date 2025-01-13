package com.hansol.jpabestpractices.ch01.one;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToOneAuthorRepository extends JpaRepository<OneToOneAuthor, Long> {
}
