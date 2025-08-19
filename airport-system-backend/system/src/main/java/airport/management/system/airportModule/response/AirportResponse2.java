package airport.management.system.airportModule.response;

import airport.management.system.airportModule.model.AirportType;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.gateModule.response.GateResponse;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.terminalModule.model.Terminal;
import airport.management.system.terminalModule.response.TerminalResponse;
import lombok.*;

import java.util.ArrayList;
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

    @Builder.Default
    private Set<AirportType> airportTypes = new HashSet<>();

    @Builder.Default
    private List<Flight> outgoingFlight = new ArrayList<>();

    @Builder.Default
    private List<Flight> incomingFlight = new ArrayList<>();

    @Builder.Default
    private List<Staff> staff = new ArrayList<>();

    @Builder.Default
    private List<GateResponse> gates = new ArrayList<>();

    @Builder.Default
    private List<TerminalResponse> terminals = new ArrayList<>();

}
