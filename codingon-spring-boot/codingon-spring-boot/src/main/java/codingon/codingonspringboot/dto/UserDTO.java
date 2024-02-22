package codingon.codingonspringboot.dto;

import lombok.*;

@Getter
@Setter
public class UserDTO {
    private int age;

    // 특정 필드에만 어노테이션을 붙일 수 있음
    // @Getter
    // @Setter
    private String name;

}

// UserDTO
// - 요청 시 전달된 값을 담는데 사용할 객체

// 참고. DTO 사용 이유
// - 비즈니스 로직 캡슐화
// : 모델은 데이터베이스 테이블 구조와 매우 유사함. DTO로 바꿔서 변환하면 외부 사용자에게 서비스 내부의 로직, 데이터베이스의 구조를 숨길 수 있음
// 외부 사용자에게 서비스 내부의 로직, 데이터베이스 구조를 숨길 수 있음
// - 클라이언트로 반환시 부가 정보 추가 가능
// : ex. 에러 메세지

// 참고. Lombok 라이브러리
// - getter, setter builder, constructor 등의 코드를 자동 생성(애플리케이션 실행 후에 생성됨)
// - @Builder : 빌더 패턴 지원
// - @NonNull : null 이 될 수 없음
// - @RequiredArgsConstructor : 인자를 갖는 생성자
// - @NoArgsConstructor : 매개변수가 없는 생성자
// - @AllArgsConstructor : 모든 멤버 변수를 매개변수로 받는 생성자
// - @Data : 클래스 멤버변수의 getter, setter 자동 구현


