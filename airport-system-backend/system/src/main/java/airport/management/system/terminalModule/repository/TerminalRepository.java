package airport.management.system.terminalModule.repository;

import airport.management.system.terminalModule.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Long, Terminal> {
}
