package spring.boot.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Board { // Model: 사용자가 편집하길 원하는 모든 데이터를 가지고 있어야 한다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 번호 부여
    private Integer id;

    @Column(length = 200)   // 최대 길이 200
    private String title;

    @Column(columnDefinition = "text")  // db column에 text를 직접적으로 넣을 수 있음
    private String content;

    @CreatedDate    // 날짜 생성
    private LocalDateTime create_at;
}
