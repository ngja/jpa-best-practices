package com.hansol.jpabestpractices.ch01.bidirectional;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String genre;

    private String name;

    /**
     * p.42
     * 항상 부모측에서 자식 측으로 전이 사용
     *  CascadeType.PERSIST - 영속화 시 연관 엔티티도 같이
     *  CascadeType.MERGE - 상태 변경 시 연관 엔티티도 같이
     *  CascadeType.REMOVE - 제거 시 연관 엔티티도 같이
     *  CascadeType.REFRESH - 새로고침 시 연관 엔티티도 같이
     *  CascadeType.DETACH - 연속성 컨텍스트 분리 시 연관 엔티티도 같이
     *  CascadeType.ALL - 위에 전부 다
     * 잘못 쓸 경우 발생 가능한 문제
     *  - 참조 무결성 졔약조건 위반
     *  - 양방향 연관 관계 매핑 시 충돌, 순환참조
     * p.43
     * 부모측에 mappedBy 지정
     *  연관관계의 주인 - DB 상 외래키를 관리하는 엔티티
     *  주인이 아닌쪽에서 mappedBy를 지정함으로 자식측을 미러링한다는 신호를 보냄
     *  mappedBy가 필요한 이유 - 객체는 양방향 연관관계라 없고 테이블은 가능한 차이를 해결하기 위해
     * p.43
     * 부모측에 orphanRemoval 지정
     *  참조되니 않는 자식의 삭제 보장
     * p.46
     * toString 사용 시 기본 속성만 포함해야함
     * 순환 참조 문제나 별도 SQL 문이 나갈 수 있기 때문에
     */
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<Book> books;

    /**
     * p.44
     * 연관관계 편의 메서드
     */
    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        book.setAuthor(null);
        this.books.remove(book);
    }
}
