package manager2.employee.dto;

import com.manager2.department.entity.deEntity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class emDTO {
    private Long eid;
    private String ename;
    private String grade;
    private String fileName;


    @ManyToOne
    private deEntity deentity;

}
