package eval.remypaquin.eval.dao;

import eval.remypaquin.eval.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheDao extends JpaRepository<Tache, Integer> {
}
