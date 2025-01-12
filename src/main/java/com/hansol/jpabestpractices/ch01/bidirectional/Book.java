package com.hansol.jpabestpractices.ch01.bidirectional;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    /**
     * p.45
     * 연관관계 양측에서 지연 로딩 사용
     * OneToMany 는 기본 FetchType.LAZY 설정
     * ManyToOne 은 FetchType.EAGER 로 설정되어있는데
     * 명시적으로 지연으로 설정하고 쿼리 기반으로 가져올 때만 즉시 가져오는 게 좋음
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author;

    /**
     * p.45
     * equals(), hashCode() 오버라이딩
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}
