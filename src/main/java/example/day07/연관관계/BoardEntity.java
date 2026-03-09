package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer bno;
    private String bcontent;
    // 단방향 fk 만들기
        // @JoinColumn 관례적으로 fk필드명도 pk필드명과 동일
        // @ManyToOne ektnrk gkskdprp , 1:n
    @ManyToOne
    @JoinColumn(name = "cno") // 관례적으로 fk필드명은 pk필드명과 동일
    private CategoryEntity categoryEntity;

    // 양방향
    @OneToMany(mappedBy = "boardEntity")
    @ToString.Exclude @Builder.Default
    private List<ReplyEntity> replyEntities=new ArrayList<>();




}
