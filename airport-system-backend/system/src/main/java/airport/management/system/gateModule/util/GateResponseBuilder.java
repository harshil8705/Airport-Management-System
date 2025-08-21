package airport.management.system.gateModule.util;

import airport.management.system.airportModule.utils.BuildAirportResponse;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.gateModule.response.GateResponse;
import airport.management.system.gateModule.response.GateResponse2;
import airport.management.system.terminalModule.util.BuildTerminalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class GateResponseBuilder {

    @Autowired
    private BuildAirportResponse buildAirportResponse;

    @Lazy
    @Autowired
    private BuildTerminalResponse buildTerminalResponse;


    public GateResponse buildGateResponse(Gate gate) {

        return GateResponse.builder()
                .gateId(gate.getGateId())
                .closeTime(gate.getCloseTime())
                .createdAt(gate.getCreatedAt())
                .gateCode(gate.getGateCode())
                .gateStatus(gate.getGateStatus())
                .openTime(gate.getOpenTime())
                .updatedAt(gate.getUpdatedAt())
                .build();

    }

    public GateResponse2 buildGateResponse2(Gate gate) {

        return GateResponse2.builder()
                .gateId(gate.getGateId())
                .gateCode(gate.getGateCode())
                .openTime(gate.getOpenTime())
                .closeTime(gate.getCloseTime())
                .updatedAt(gate.getUpdatedAt())
                .createdAt(gate.getCreatedAt())
                .gateStatus(gate.getGateStatus())
                .airportResponse(gate.getAirport() == null ? null : buildAirportResponse.buildAirportResponse(gate.getAirport()))
                .terminalResponse(gate.getTerminal() == null ? null : buildTerminalResponse.buildTerminalResponse(gate.getTerminal()))
                .flight(gate.getFlight() == null ? null : gate.getFlight())
                .build();

    }

}
