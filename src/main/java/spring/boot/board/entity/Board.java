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
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @CreatedDate
    private LocalDateTime create_at;
}
