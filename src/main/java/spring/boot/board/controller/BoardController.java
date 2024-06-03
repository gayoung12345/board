package spring.boot.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot.board.entity.Board;
import spring.boot.board.service.BoardService;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController { // Controller: 데이터와 UI를 연결하는 역할

    @Autowired
    private final BoardService boardService;

    // http://local:8080/board/hello
    // 화면에 "Hello Spring Boot" 출력
    @GetMapping("/hello")
    @ResponseBody   // return 값 그대로 반환
    public String hello() {
        return "Hello Spring Boot"; // 화면에 출력
    }

    // http://local:8080/board/write
    // board table에 값을 저장
    @GetMapping("/write")
    public String boardWriteForm(Model model, @RequestParam(value = "id", required = false) Integer id) {
        if (id != null) {
            Board board = boardService.boardView(id);
            model.addAttribute("board", board);
        } else {
            model.addAttribute("board", new Board());
        }
        return "boardwrite";
    }

    @PostMapping("/writeProc")
    public String boardWriteProc(Board board) {
        if (board.getId() != null) {
            boardService.modify(board.getId(), board.getTitle(), board.getContent());
            return "redirect:/board/view?id=" + board.getId();
        } else {
            boardService.write(board);
            return "redirect:/board/list";
        }
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/view")
    public String boardView(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }

    @GetMapping("/modify")
    public String boardModifyForm(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardwrite"; // 수정폼으로 boardwrite.html을 사용
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(Board board, @PathVariable("id") Integer id) {
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String deleteBoard(@RequestParam("id") Integer id) {
        boardService.boardDelete(id);
        return "redirect:/board/list"; // 삭제 후 리스트 페이지로 리다이렉트
    }

}