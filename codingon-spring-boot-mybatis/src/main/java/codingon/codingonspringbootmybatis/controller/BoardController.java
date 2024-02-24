package codingon.codingonspringbootmybatis.controller;

import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.domain.User;
import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.dto.UserDTO;
import codingon.codingonspringbootmybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/prac/board")
    public String pracBoard(Model model) {

        List<BoardDTO> boards = boardService.getBoardList();
        model.addAttribute("list", boards);
        return "board";
    }

    @PostMapping("/prac/boardInsert")
    public String pracBoardInsert(@RequestParam String title, @RequestParam String content, @RequestParam String writer, Model model) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        boardService.insertBoard(board);
        List<BoardDTO> boards = boardService.getBoardList();
        model.addAttribute("list", boards);
        return "board";
    }

    @GetMapping("/prac/allBoard")
    public String pracGetAllBoard(Model model) {
        List<BoardDTO> boards = boardService.getBoardList();
        model.addAttribute("list", boards);
        return "redirect:/prac/board";
    }

    @GetMapping("/prac/titleBoard")
    public String pracGetBoard(@RequestParam String title, Model model) {
        Board board = new Board();
        board.setTitle(title);
        List<BoardDTO> boards = boardService.getTitleBoardList(board);
        System.out.println(boards);
        model.addAttribute("list", boards);
        return "board";
    }

    @DeleteMapping("/prac/deleteBoard")
    public String pracDeleteBoard(@RequestParam int id, Model model) {
        Board board = new Board();
        board.setId(id);
        boardService.deleteBoard(board);
        return "redirect:/prac/board";
    }

    @PatchMapping("/prac/updateBoard")
    public String pracUpdateBoard( @RequestParam int id, String title, String content, String writer,Model model) {
        Board board = new Board();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        boardService.updateBoard(board);
        return "redirect:/prac/board";
    }
}
