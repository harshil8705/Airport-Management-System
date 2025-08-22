package airport.management.system.staffModule.service;

import airport.management.system.exceptionModule.ApiException;
import airport.management.system.staffModule.model.*;
import airport.management.system.staffModule.repository.StaffRepository;
import airport.management.system.staffModule.repository.StaffRolesRepository;
import airport.management.system.staffModule.repository.StaffStatusRepository;
import airport.management.system.staffModule.request.StaffRequest;
import airport.management.system.staffModule.util.StaffResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StaffStatusRepository staffStatusRepository;

    @Autowired
    private StaffRolesRepository staffRolesRepository;

    @Autowired
    private StaffResponseBuilder staffResponseBuilder;

    @Override
    public Object addNewStaff(StaffRequest staffRequest) {

        Staff staff = Staff.builder()
                .fullName(staffRequest.getFullName())
                .email(staffRequest.getEmail())
                .dateOfBirth(staffRequest.getDateOfBirth())
                .dateOfJoining(LocalDate.now())
                .phoneNumber(staffRequest.getPhoneNumber())
                .assignedAirport(null)
                .assignedFlight(null)
                .build();

        StaffStatusEnum typeEnum = StaffStatusEnum.valueOf(staffRequest.getStaffStatus().toUpperCase());
        StaffStatus staffStatus = staffStatusRepository.findByStaffStatus(typeEnum);

        if (staffStatus != null) {

            staff.setStaffStatus(staffStatus);

        }

        StaffRolesEnum typeEnum1 = StaffRolesEnum.valueOf(staffRequest.getStaffRoles().toUpperCase());
        StaffRoles staffRoles = staffRolesRepository.findByStaffRoles(typeEnum1);

        if (staffRoles != null) {

            staff.setStaffRoles(staffRoles);

        }

        Staff newStaff = staffRepository.save(staff);

        return staffResponseBuilder.buildStaffResponse(newStaff);

    }

    @Override
    public Object getStaffById(Long staffId) {

        Staff existingStaff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ApiException("No staff found by staffId: " + staffId));

        return staffResponseBuilder.buildStaffResponse(existingStaff);

    }


}
