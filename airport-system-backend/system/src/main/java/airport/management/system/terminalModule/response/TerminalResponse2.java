package airport.management.system.terminalModule.response;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.airportModule.request.AirportRequest;
import airport.management.system.airportModule.response.AirportResponse;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.terminalModule.model.TerminalType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalResponse2 {

    private Long terminalId;
    private String terminalCode;
    private String location;
    private Integer totalGates;

    @Builder.Default
    private Set<TerminalType> terminalTypes = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;

    @Builder.Default
    private List<Gate> gates = new ArrayList<>();

    @Builder.Default
    private List<Flight> flights = new ArrayList<>();

    private AirportResponse airport;

}
