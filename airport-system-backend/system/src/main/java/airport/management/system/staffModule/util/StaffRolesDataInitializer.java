package airport.management.system.staffModule.util;

import airport.management.system.staffModule.model.StaffRoles;
import airport.management.system.staffModule.model.StaffRolesEnum;
import airport.management.system.staffModule.repository.StaffRolesRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StaffRolesDataInitializer {

    @Autowired
    private StaffRolesRepository staffRolesRepository;

    @PostConstruct
    public void insertStaffRoles() {

        if(staffRolesRepository.count() == 0) {

            StaffRoles pilot = StaffRoles.builder()
                    .staffRoleId(1L)
                    .staffRoles(StaffRolesEnum.PILOT)
                    .build();
            staffRolesRepository.save(pilot);

            StaffRoles cabinCrew = StaffRoles.builder()
                    .staffRoleId(2L)
                    .staffRoles(StaffRolesEnum.CABIN_CREW)
                    .build();
            staffRolesRepository.save(cabinCrew);

            StaffRoles groundStaff = StaffRoles.builder()
                    .staffRoleId(3L)
                    .staffRoles(StaffRolesEnum.GROUND_STAFF)
                    .build();
            staffRolesRepository.save(groundStaff);

            StaffRoles airTrafficController = StaffRoles.builder()
                    .staffRoleId(4L)
                    .staffRoles(StaffRolesEnum.AIR_TRAFFIC_CONTROLLER)
                    .build();
            staffRolesRepository.save(airTrafficController);

            StaffRoles securityOfficer = StaffRoles.builder()
                    .staffRoleId(5L)
                    .staffRoles(StaffRolesEnum.SECURITY_OFFICER)
                    .build();
            staffRolesRepository.save(securityOfficer);

            StaffRoles maintenanceEngineer = StaffRoles.builder()
                    .staffRoleId(6L)
                    .staffRoles(StaffRolesEnum.MAINTENANCE_ENGINEER)
                    .build();
            staffRolesRepository.save(maintenanceEngineer);

            StaffRoles admin = StaffRoles.builder()
                    .staffRoleId(7L)
                    .staffRoles(StaffRolesEnum.ADMIN)
                    .build();
            staffRolesRepository.save(admin);

            System.out.println("Staff Roles Initialized.");

        } else {
            System.out.println("Staff Roles already exists. Skipping Initialization.");
        }

    }

}
