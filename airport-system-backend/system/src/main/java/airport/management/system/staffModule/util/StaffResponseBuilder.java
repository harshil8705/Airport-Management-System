package airport.management.system.staffModule.util;

import airport.management.system.staffModule.model.Staff;
import airport.management.system.staffModule.response.StaffResponse;
import org.springframework.stereotype.Component;

@Component
public class StaffResponseBuilder {

    public StaffResponse buildStaffResponse(Staff staff) {

        return StaffResponse.builder()
                .staffId(staff.getStaffId())
                .staffStatus(staff.getStaffStatus())
                .staffRoles(staff.getStaffRoles())
                .email(staff.getEmail())
                .dateOfBirth(staff.getDateOfBirth())
                .dateOfJoining(staff.getDateOfJoining())
                .fullName(staff.getFullName())
                .phoneNumber(staff.getPhoneNumber())
                .build();

    }

}
