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
    private Integer cno;

    private String cname;

    @OneToMany(mappedBy = "courseEntity")
    @ToString.Exclude
    @Builder.Default
    private List<StudentEntity> studentEntityList = new ArrayList<>();


}
