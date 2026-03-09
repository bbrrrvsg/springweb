package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor@NoArgsConstructor@Data@Builder
@Entity@Table(name = "reply")
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;

    private String rcontent;
    // 단방향 fk 만들기
    @ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER )
    @JoinColumn(name = "bno") // fk 필드명
    private BoardEntity boardEntity;

}
/*
    - 영속성이란? 자바 객체 외 데이터베이스 데이터 간 매핑/연결 상태
        - 영속성 채페란? 자바객체 와 데이터베이스 데이터 간 매핑/연결 해체
    - cascade 속성이란? pk 와 fk 제약조건 옵션
        - CascadeType.ALL : 부모가 삭제/수정/저장 되면 같이 삭제/수정/저장 반영된다. **
        - CascadeType.REMOVE : 부모가 삭제 되면 자식도 같이 삭제
        - CascadeType.MERGE : 부모가 수정되면 자식도 같이 수정
        - CascadeType.DETACH : 부모가 영속 해체 되면 자식도 같이 영속 해체 된다.
        - CascadeType.REFRESH : 부모가 재호출(갱신) 되면 자식도 같이 재호출(갱신)된다.
        - CascadeType.PERSIST : 부모가 저장되면 자식도 같이 저장된다.   // 게시글만 저장해도 댓글도 저장됨    // 단? 보드가 댓글을 참조할때
    - fetch : 부모 [pk] 조회시 자식[fk] 관계에서 엔티티 조회여부 선택
        -FetchType.EAGER : (기본값) 해당 엔티티 조회시 참조 엔티티 모두 즉시 조회한다.
            - 특징 : 초기 로딩 느리다, 재사용시 빠르다 , *불필요한 정보까지 있을경우 성능 저하*

        -FetchType.LAZY : 해당 엔티티 조회시 참조 엔티티는 조회 하지않는다. <참조 엔티티 호출시 조회>
            - 특징 : 초기 로딩 빠르다, 재사용성 느리다. *필요한 정보까지 만 적절하게 사용* <지연 로딩>

    - 단방향/양방향 활용
        -만약에 1번 카테고리에 게시물 등록할 경우  , fk 필드에 fk값이 아닌 fk엔티티 대입한다.
            BoardEntity saveEntity = new BoardEntity();

            // saveEntity.setCategory(1);[x]

            Category category = repository.findById(1).get();
            saveEntity.setCategory(category);[o]
            repository.save(saveEntity);

        - 만약에 3번 게시물에 댓글 등록 한다면  **fk 필드에 fk값만 3 대신에 3갖는 fk엔티티 찾아서 대입하자.
            ReplyEntity saveEntity = new ReplyEntity();
                BoardEntity board = repository.findById(3).get();
            saveEntity.setBoardEntity(board);
            repository.save(saveEntity);

 */
