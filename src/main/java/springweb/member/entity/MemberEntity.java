package springweb.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.member.dto.MemberDto;

@Entity@Table(name = "member")
@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class MemberEntity extends baseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(nullable = false, unique = true, length = 100)
    private String mid;

    @Column(nullable = false)
    private String mpwd;

    @Column(nullable = false, length = 30)
    private String mname;

    // Emtity --> DTO 주로 조회
    public MemberDto ToDto(){
        return MemberDto
                .builder()
                .mno(mno)
                .mid(mid)
                //.mpwd(mpwd) 주로 패스워드는 DTO로 반환하지 않는다
                .mname(mname)
                .update_date(getUpdate_date().toString())
                .create_date(getCreate_date().toString())
                .build();
    }

}
