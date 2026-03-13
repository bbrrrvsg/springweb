package example.prcatice.practice7.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Data@Builder
@Entity@Table(name = "course")
public class CourseEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private String cname;

    //양방향
    @OneToMany(mappedBy = "courseEntity")
    @ToString.Exclude@Builder.Default
    private List<EnrollEntity>enrollEntityList = new ArrayList<>();





}
