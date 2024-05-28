package spring.boot.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.board.entity.Board;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void write (String title, String content){
        Board board =new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setCreate_at(LocalDateTime.now());
        this.boardRepository.save(board);
    }

}
