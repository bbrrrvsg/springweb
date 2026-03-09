package example.prcatice.practice7.repository;

import example.prcatice.practice7.Entity.EnrollEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Integer> {
}
