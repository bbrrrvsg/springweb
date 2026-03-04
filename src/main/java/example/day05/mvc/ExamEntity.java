package example.day05.mvc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 해당 객체는 데이터베이스 연동 하겠다는 뜻
@Table( name="exam") // 데이터베이스 에서 테이블명 정의
@Data@NoArgsConstructor@AllArgsConstructor // 롬복
public class ExamEntity {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer eno;

    @Column(name = "ename", length = 255, nullable = false) // 테이블 필드 속성
    private String ename;
}
// Entity 데이터베이스와 객체 간 연동 객체