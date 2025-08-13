package airport.management.system.terminalModule.util;

import airport.management.system.terminalModule.model.Terminal;
import airport.management.system.terminalModule.response.TerminalResponse;
import org.springframework.stereotype.Component;

@Component
public class BuildTerminalResponse {

    public TerminalResponse buildTerminalResponse(Terminal terminal) {

        return TerminalResponse.builder()
                .terminalId(terminal.getTerminalId())
                .terminalTypes(terminal.getTerminalTypes().isEmpty() ? null : terminal.getTerminalTypes())
                .terminalCode(terminal.getTerminalCode())
                .createdAt(terminal.getCreatedAt())
                .isActive(terminal.getIsActive())
                .location(terminal.getLocation())
                .totalGates(terminal.getTotalGates())
                .updatedAt(terminal.getUpdatedAt())
                .build();

    }

}
