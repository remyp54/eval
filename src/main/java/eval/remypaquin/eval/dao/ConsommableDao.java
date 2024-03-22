package eval.remypaquin.eval.dao;

import eval.remypaquin.eval.models.Consommable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsommableDao extends JpaRepository<Consommable, Integer> {
}
