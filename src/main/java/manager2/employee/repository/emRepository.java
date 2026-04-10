package manager2.employee.repository;

import com.manager2.employee.entity.emEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface emRepository extends JpaRepository<emEntity,Long> {
}
