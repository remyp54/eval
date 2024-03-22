package eval.remypaquin.eval.dao;

import eval.remypaquin.eval.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {
}

