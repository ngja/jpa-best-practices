package com.hansol.jpabestpractices.ch01.many;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "many_book")
public class ManyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    /**
     * mappedBy 로 연관관계의 주인 설정
     * List 가 아닌 Set 사용하기
     * CascadeType.ALL, CascadeType.REMOVE 사용하지 않기
     * 양측 모두 지연 로딩 사용 (기본값)
     */
    @ToString.Exclude
    @ManyToMany(mappedBy = "books")
    private Set<ManyAuthor> authors = new HashSet<>();
}
