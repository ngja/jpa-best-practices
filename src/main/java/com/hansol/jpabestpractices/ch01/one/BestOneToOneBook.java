package com.hansol.jpabestpractices.ch01.one;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "best_one_book")
public class BestOneToOneBook {

    @Id
    private Long id;

    private String isbn;

    private String title;

    /**
     * pk 를 author 의 pk 와 동일하게 가져간다.
     * MapsId 사용 시 이점
     *  Book 이 2차 캐시에 있으면 캐시에서 가져온다.
     *  Author 를 가져올 때 Book 을 가져오는 불필요한 쿼리를 막는다
     *  기본키 공유 시 메모리 사용량 이점
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private OneToOneAuthor author;
}
