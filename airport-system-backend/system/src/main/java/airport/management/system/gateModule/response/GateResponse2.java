package airport.management.system.gateModule.response;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.airportModule.response.AirportResponse;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.GateStatus;
import airport.management.system.terminalModule.response.TerminalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GateResponse2 {

    private Long gateId;
    private String gateCode;
    private GateStatus gateStatus;
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private AirportResponse airportResponse;
    private Flight flight;
    private TerminalResponse terminalResponse;

}
