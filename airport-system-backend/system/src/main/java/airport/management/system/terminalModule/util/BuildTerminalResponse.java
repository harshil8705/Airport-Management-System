package airport.management.system.terminalModule.util;

import airport.management.system.airportModule.utils.BuildAirportResponse;
import airport.management.system.gateModule.util.GateResponseBuilder;
import airport.management.system.terminalModule.model.Terminal;
import airport.management.system.terminalModule.response.TerminalResponse;
import airport.management.system.terminalModule.response.TerminalResponse2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildTerminalResponse {

    @Autowired
    private BuildAirportResponse buildResponse;

    @Autowired
    private GateResponseBuilder gateResponseBuilder;

    public TerminalResponse buildTerminalResponse(Terminal terminal) {

        return TerminalResponse.builder()
                .terminalId(terminal.getTerminalId())
                .terminalTypes(terminal.getTerminalTypes().isEmpty() ? null : terminal.getTerminalTypes())
                .terminalCode(terminal.getTerminalCode())
                .createdAt(terminal.getCreatedAt())
                .isActive(terminal.getIsActive())
                .location(terminal.getLocation())
                .totalGates(terminal.getGates().isEmpty() ? 0 : terminal.getGates().size())
                .updatedAt(terminal.getUpdatedAt())
                .build();

    }

    public TerminalResponse2 buildTerminalResponse2(Terminal terminal) {

        return TerminalResponse2.builder()
                .terminalId(terminal.getTerminalId())
                .terminalCode(terminal.getTerminalCode())
                .terminalTypes(terminal.getTerminalTypes())
                .airport(terminal.getAirport() == null ? null : buildResponse.buildAirportResponse(terminal.getAirport()))
                .createdAt(terminal.getCreatedAt())
                .flights(terminal.getFlights())
                .gates(terminal.getGates().stream().map(gate -> gateResponseBuilder.buildGateResponse(gate)).toList())
                .isActive(terminal.getIsActive())
                .location(terminal.getLocation())
                .totalGates(terminal.getGates().isEmpty() ? 0 : terminal.getGates().size())
                .updatedAt(terminal.getUpdatedAt())
                .build();

    }

}
