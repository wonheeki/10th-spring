package codingon.codingonspringbootjpa.dto;

import lombok.*;

@Data
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String nickname;
    private int no;
}

