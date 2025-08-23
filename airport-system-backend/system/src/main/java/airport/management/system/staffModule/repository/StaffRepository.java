package airport.management.system.staffModule.repository;

import airport.management.system.staffModule.model.Staff;
import airport.management.system.staffModule.model.StaffRoles;
import airport.management.system.staffModule.model.StaffStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Page<Staff> findByFullNameContainingIgnoreCase(String name, Pageable pageDetails);

    Page<Staff> findByStaffRoles(StaffRoles staffRole, Pageable pageDetails);

    Page<Staff> findByStaffStatus(StaffStatus status, Pageable pageDetails);

}
