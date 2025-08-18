package airport.management.system.gateModule.util;

import airport.management.system.gateModule.model.Gate;
import airport.management.system.gateModule.response.GateResponse;
import org.springframework.stereotype.Component;

@Component
public class GateResponseBuilder {

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

}
