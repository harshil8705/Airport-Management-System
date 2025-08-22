package airport.management.system.staffModule.repository;

import airport.management.system.staffModule.model.StaffStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffStatusRepository extends JpaRepository<StaffStatus, Long> {
}
