package manager2.department.repository;

import com.manager2.department.entity.deEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface deRepository extends JpaRepository<deEntity,Long> {
}
