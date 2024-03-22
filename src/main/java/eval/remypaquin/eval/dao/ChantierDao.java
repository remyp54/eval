package eval.remypaquin.eval.dao;

import eval.remypaquin.eval.models.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChantierDao extends JpaRepository<Chantier, Integer> {
}
