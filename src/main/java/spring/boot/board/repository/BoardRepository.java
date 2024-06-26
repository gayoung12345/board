package spring.boot.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
