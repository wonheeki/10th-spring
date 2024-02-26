package codingon.codingonspringbootmybatis.controller;

import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board") // 공동 경로
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("")
    public String getBoards(Model model) {
        // 1. 전부 select
        List<BoardDTO> list = boardService.getAll();
        model.addAttribute("list", list);
        return "board";
    }

    @PostMapping("")
    @ResponseBody
    public void postBoard(@RequestBody Board board) {
        // 2. 게시글 작성 - insert
        boardService.insertBoard(board);
    }

    @PatchMapping("")
    @ResponseBody
    public void patchBoard(@RequestBody Board board) {
        // 3. 게시글 수정 - update
        boardService.patchBoard(board);
    }

    @DeleteMapping("")
    @ResponseBody
    public void deleteBoard(@RequestParam int id) {
        // 4. 게시글 삭제 - delete
        boardService.deleteBoard(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public int searchBoard(@RequestParam String word) {
        // 5. 게시글 검색 - get
        return boardService.searchBoard(word);
    }
}
