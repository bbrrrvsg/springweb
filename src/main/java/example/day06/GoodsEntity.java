package example.day06;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor@NoArgsConstructor@Data@Builder
@Entity @Table(name = "goods") // 생략시 클래스명으로 자동설정
public class GoodsEntity extends baseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gno;

    @Column(name = "제품명", nullable = false , length = 100, unique = true)
    private String gname;

    // @Column  생략가능 : 자바의 타입 --> sql타입 , 자바의 변수명 --> sql 필드명
    private Integer gprice;

    @Column(columnDefinition ="varchar(100) default '제품설명' not null") // 수동으로 가능
    private String gdesc;

    //ENTITY --> DTO 변환함수
    public GoodsDto toDto(){
        return GoodsDto
                .builder()
                .gno(this.gno) // this 해당메소드를 호출한 객체 생략가능
                .gname(gname)
                .gprice(gprice)
                .gdesc(gdesc)
                .createdate(getCreatedate().toString())
                .updatedate(getUpdatedate().toString())
                .build();
    }

}
/*
      @Id : pk
      @GeneratedValue(strategy = GenerationType.IDENTITY) : auto_increment
      @Column()
        name="필드명"          , 기본값은 자바필드명
        nullable=false          ,기본값은 true
        length = 길이             , 기본값은 255
        unique = true           , 기본값은 false
        insertable=true         , 기본값은 ture , insert할때 적용여부
        updateable=true         ,기본값은 true , update할때 적용여부
        columnDefinition ="sql" , JPA가 아닌 네이티브(실제sql) 쿼리

        레코드 생성(회원가입/등록일/주문일/작성일 등등 )날짜 / 수정(게시판수정 등등)날짜
 */