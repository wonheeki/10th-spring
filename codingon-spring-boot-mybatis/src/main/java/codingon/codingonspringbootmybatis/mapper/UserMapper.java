package codingon.codingonspringbootmybatis.mapper;

import codingon.codingonspringbootmybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 스프링 부트에게 매퍼 역할을 하는 인터페이스임을 알림
public interface UserMapper {
    // sql과 객체를 매핑해주는 곳으로 실제 DB 접속할 때 실행한 SQL문 정의
    
    // case 1. xml파일 (mapper 파일) 참고
    // UserMapper.xml 의 id값과 함수이름이 같아야 함
    List<User> retrieveAll();

    
    // case 2. xml 파일 (mapper 파일) 참고하지 않고, sql을 실행
    @Insert("insert into user(name,nickname) values(#{name},#{nickname})")
    void insertUser(User user);
    // void insertUser(String name, String nickname);
}

