package airport.management.system.airportModule.response;

import airport.management.system.airportModule.model.AirportType;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.terminalModule.model.Terminal;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportResponse2 {

    private Long airportId;
    private String airportName;
    private String city;
    private String country;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AirportType> airportTypes;
    private List<Flight> outgoingFlight;
    private List<Flight> incomingFlight;
    private List<Staff> staff;
    private List<Gate> gates;
    private List<Terminal> terminals;

}
