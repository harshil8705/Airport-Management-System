package airport.management.system.terminalModule.repository;

import airport.management.system.terminalModule.model.Terminal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {

    Page<Terminal> findByTerminalCodeContainingIgnoreCase(String terminalCode, Pageable pageRequest);

}
