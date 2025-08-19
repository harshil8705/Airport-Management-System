package airport.management.system.gateModule.repository;

import airport.management.system.gateModule.model.Gate;
import airport.management.system.gateModule.model.GateStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {

    Page<Gate> findByGateCodeContainingIgnoreCase(String gateCode, Pageable pageDetails);

    Page<Gate> findByGateStatus(GateStatus gateStatus1, Pageable pageDetails);

}
