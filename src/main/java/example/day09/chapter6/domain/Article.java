package example.day09.chapter6.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity // 해당 클래스를 엔티티로 지정
@Data // @Getter + @Setter + @ToString 등등 포함
@NoArgsConstructor( access = AccessLevel.PROTECTED ) // 접근제한자 설정 ,
@AllArgsConstructor
@Builder // 빌더패턴 적용
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id // primary key 지정
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    @Column( name = "id" , updatable = false ) // 수정 불가능
    private Long id;
    @Column( name = "title" , nullable = false )
    private String title;
    @Column( name = "content" , nullable = false )
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public void update( String title , String content ){
        this.title = title;
        this.content = content;
    }
}
