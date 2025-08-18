package airport.management.system.gateModule.repository;

import airport.management.system.gateModule.model.GateStatus;
import airport.management.system.gateModule.model.GateStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateStatusRepository extends JpaRepository<GateStatus, Long> {

    GateStatus findByGateStatus(GateStatusEnum typeEnum);

}
