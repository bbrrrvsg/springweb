package example.prcatice.practice6;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class MovieDto {
    private Integer mid;
    private String mtitle;
    private String mdirector;
    private String mreleasedate;
    private Integer mrating;

    private String createdate;
    private String updatedate;


    //dto--> 엔티티
    public MovieEntity toEntity(){
        return MovieEntity
                .builder()
                .mid(mid)
                .mdirector(mdirector)
                .mrating(mrating)
                .mreleasedate(mreleasedate)
                .mtitle(mtitle)
                .build();
    }
}
