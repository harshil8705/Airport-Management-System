package airport.management.system.terminalModule.repository;

import airport.management.system.terminalModule.model.TerminalType;
import airport.management.system.terminalModule.model.TerminalTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerminalTypeRepository extends JpaRepository<TerminalType, Long> {

    Optional<TerminalType> findByTerminalType(TerminalTypeEnum typeEnum);

}
