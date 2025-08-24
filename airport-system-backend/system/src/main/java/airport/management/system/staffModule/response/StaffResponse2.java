package airport.management.system.staffModule.response;

import airport.management.system.airportModule.response.AirportResponse;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.staffModule.model.StaffRoles;
import airport.management.system.staffModule.model.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffResponse2 {

    private Long staffId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private LocalDate dateOfBirth;
    private StaffRoles staffRoles;
    private StaffStatus staffStatus;
    private Flight assignedFlight;
    private AirportResponse assignedAirport;

}
