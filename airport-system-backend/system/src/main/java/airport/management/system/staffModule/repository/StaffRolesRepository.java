package airport.management.system.staffModule.repository;

import airport.management.system.staffModule.model.StaffRoles;
import airport.management.system.staffModule.model.StaffRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRolesRepository extends JpaRepository<StaffRoles, Long> {

    StaffRoles findByStaffRoles(StaffRolesEnum typeEnum1);

}
