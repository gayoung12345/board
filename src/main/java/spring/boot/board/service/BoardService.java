package spring.boot.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.board.entity.Board;
import spring.boot.board.repository.BoardRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private final BoardRepository boardRepository;

    public void write(Board board) {
        this.boardRepository.save(board);
    }

    public List<Board> boardList() {
        return this.boardRepository.findAll();
    }

    public Board boardView(Integer id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.orElse(null);
    }

    public void modify(Integer id, String title, String content) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            board.setTitle(title);
            board.setContent(content);
            boardRepository.save(board);
        }
    }

    // 특정 게시글 삭제하기
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }


}
