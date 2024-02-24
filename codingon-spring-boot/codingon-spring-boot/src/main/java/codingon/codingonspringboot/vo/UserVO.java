package codingon.codingonspringboot.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UserVO {
    private String name;
    private String age;

    // 동등성 구현을 위한 코드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVO userVO = (UserVO) o;

        // 여기서 모든 필드를 비교
        return Objects.equals(name, userVO.name) && Objects.equals(age,userVO.age);
    }

    @Override
    public int hashCode() {
        // 필드들을 이용한 해시코드 생성
        return Objects.hash(name, age);
    }
}