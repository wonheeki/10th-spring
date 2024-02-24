package codingon.codingonspringbootmybatis.service;

import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.domain.User;
import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.dto.UserDTO;
import codingon.codingonspringbootmybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> getBoardList(){
        List<Board> boards = boardMapper.getBoard();
        List<BoardDTO> result = new ArrayList<>();

        for (Board board : boards) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .id(board.getId()+100).build();

            result.add(boardDTO);
        }
        return  result;
    }

    public List<BoardDTO> getTitleBoardList(Board b) {
        List<Board> boards = boardMapper.getTitleBoard(b);
        List<BoardDTO> result = new ArrayList<>();

        for (Board board : boards) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .id(board.getId() + 100).build();

            result.add(boardDTO);
        }
        return result;
    }

    public void insertBoard(Board board){
        boardMapper.insertBoard(board);
    }

    public void updateBoard(Board board){
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(Board board){
        boardMapper.deleteBoard(board);
    }
}
