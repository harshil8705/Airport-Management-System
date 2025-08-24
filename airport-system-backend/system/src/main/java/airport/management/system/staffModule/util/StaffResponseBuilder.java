package airport.management.system.staffModule.util;

import airport.management.system.airportModule.utils.BuildAirportResponse;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.staffModule.response.StaffResponse;
import airport.management.system.staffModule.response.StaffResponse2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaffResponseBuilder {

    @Autowired
    private BuildAirportResponse airportResponseBuilder;

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

    public StaffResponse2 buildStaffResponse2(Staff staff) {

        return StaffResponse2.builder()
                .staffId(staff.getStaffId())
                .staffStatus(staff.getStaffStatus())
                .staffRoles(staff.getStaffRoles())
                .email(staff.getEmail())
                .dateOfBirth(staff.getDateOfBirth())
                .dateOfJoining(staff.getDateOfJoining())
                .fullName(staff.getFullName())
                .phoneNumber(staff.getPhoneNumber())
                .assignedAirport(staff.getAssignedAirport() == null
                        ? null
                        : airportResponseBuilder.buildAirportResponse(staff.getAssignedAirport())
                )
                .assignedFlight(staff.getAssignedFlight() == null ? null : staff.getAssignedFlight())
                .build();

    }

}
