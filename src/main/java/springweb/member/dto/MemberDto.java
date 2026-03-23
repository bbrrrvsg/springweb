package springweb.member.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.member.entity.MemberEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberDto {

    private Long mno;
    private String mid;
    private String mpwd;
    private String mname;

    private String create_date;
    private String update_date;



    // DTO --> Entity 주로 저장
    public MemberEntity ToEntity(){
        return MemberEntity
                .builder()
                .mid(mid)
                .mpwd(mpwd)
                .mname(mname)
                .build();
    }
}
