package manager2.department.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department")
@Data@Builder@AllArgsConstructor@NoArgsConstructor
public class deEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;

    private String dname;


}
