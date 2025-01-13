package com.hansol.jpabestpractices.ch01.one;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "one_book")
public class OneToOneBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private OneToOneAuthor author;
}
