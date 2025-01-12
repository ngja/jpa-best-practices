package com.hansol.jpabestpractices.ch01.unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidirectionalAuthorRepository extends JpaRepository<UnidirectionalAuthor, Long> {
}
