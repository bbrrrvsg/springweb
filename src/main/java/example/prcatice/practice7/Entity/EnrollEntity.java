package example.prcatice.practice7.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "enroll")
public class EnrollEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eno;
    private String ename;

    @ManyToOne
    @JoinColumn(name = "sno")
    private StudentEntity studentEntity;

}
