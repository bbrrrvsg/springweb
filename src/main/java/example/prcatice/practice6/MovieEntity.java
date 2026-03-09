package example.prcatice.practice6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class MovieEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mid;

    @Column(name = "mtitle",nullable = false)
    private String mtitle;

    @Column(name = "mdirector",nullable = false)
    private String mdirector;

    @Column(name = "mreleasedate",nullable = false)
    private String mreleasedate;

    @Column(name = "mrating", columnDefinition = "default 1")
    private Integer mrating;

    //엔티티 -> dto
    public MovieDto toDto(){
        return MovieDto
                .builder()
                .mdirector(mdirector)
                .mid(mid)
                .mrating(mrating)
                .mreleasedate(mreleasedate)
                .mtitle(mtitle)
                .createdate(getCreatedate().toString())
                .updatedate(getUpdatedate().toString())
                .build();
    }
}
