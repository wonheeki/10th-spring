package codingon.codingonspringbootmybatis.mapper;

import codingon.codingonspringbootmybatis.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoard();
    List<Board> getTitleBoard(Board board);

    void insertBoard(Board board);
    void deleteBoard(Board board);
    void updateBoard(Board board);
}
