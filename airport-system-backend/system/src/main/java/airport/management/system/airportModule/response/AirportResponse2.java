package airport.management.system.airportModule.response;

import airport.management.system.airportModule.model.AirportType;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.terminalModule.model.Terminal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportResponse2 {

    private Long airportId;
    private String airportName;
    private String city;
    private String country;
    private List<AirportType> airportTypes;
    private List<Flight> outgoingFlight;
    private List<Flight> incomingFlight;
    private List<Staff> staff;
    private List<Gate> gates;
    private List<Terminal> terminals;

}
