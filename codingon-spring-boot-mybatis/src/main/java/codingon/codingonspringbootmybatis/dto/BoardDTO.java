package codingon.codingonspringbootmybatis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
public class BoardDTO {
    private String no;
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date registered;
}
