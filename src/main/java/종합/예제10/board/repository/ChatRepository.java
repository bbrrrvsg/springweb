package 종합.예제10.board.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import 종합.예제10.board.entity.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Integer> {
}
