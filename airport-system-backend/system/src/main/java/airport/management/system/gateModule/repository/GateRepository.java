package airport.management.system.gateModule.repository;

import airport.management.system.gateModule.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Long, Gate> {
}
