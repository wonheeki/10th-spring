package codingon.codingonspringbootmybatis.service;

import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> getAll() {
        // getAll() 메소드는 "select * from board" sql 을 실행하는 함수
        List<Board> result = boardMapper.getAll();
        List<BoardDTO> list = new ArrayList<>();

        for (Board board : result) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(board.getRegistered())
                    .no(board.getWriter() + board.getId())
                    .build();

            list.add(boardDTO);
        }
        return list;
    }

    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public void patchBoard(Board board) {
        boardMapper.patchBoard(board);
    }

    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }

    public int searchBoard(String word) {
        // select 문 자체를 count 로 동작시킬 수도 있고,
        // List 로 받아와서 그에 대한 길이를 전달할 수도 있다
        List<Board> result = boardMapper.searchBoard(word);
        return result.size();
    }
}
