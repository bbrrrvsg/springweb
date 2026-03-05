package example.day06;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;
@MappedSuperclass // 엔티티 상속용도 클래스
@Getter // 상속받은 엔티티가 멤버변수 사용
public class baseTime {

    private LocalDateTime createdate;

    private LocalDateTime updatedate;
}
