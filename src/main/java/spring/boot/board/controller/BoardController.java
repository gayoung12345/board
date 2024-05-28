package spring.boot.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.boot.board.entity.Board;
import spring.boot.board.service.BoardService;


@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/hello")
    @ResponseBody // 메소드의 출력값 그대로 return
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/write")
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/writeProc")
    public String boardWriteProc(Board board){
        System.out.println("제목: " + board.getTitle());
        System.out.println("내용: " + board.getContent());
        this.boardService.write(board.getTitle(),board.getContent());
        return "boardwrite";
    }

}
