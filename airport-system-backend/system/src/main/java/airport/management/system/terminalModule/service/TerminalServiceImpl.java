package airport.management.system.terminalModule.service;

import airport.management.system.terminalModule.model.Terminal;
import airport.management.system.terminalModule.model.TerminalTypeEnum;
import airport.management.system.terminalModule.repository.TerminalRepository;
import airport.management.system.terminalModule.repository.TerminalTypeRepository;
import airport.management.system.terminalModule.request.TerminalRequest;
import airport.management.system.terminalModule.util.BuildTerminalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private TerminalTypeRepository terminalTypeRepository;

    @Autowired
    private BuildTerminalResponse terminalResponse;

    @Override
    public Object addNewTerminal(TerminalRequest terminalRequest) {

        Terminal terminal = Terminal.builder()
                .terminalCode(terminalRequest.getTerminalCode())
                .location(terminalRequest.getLocation())
                .isActive(terminalRequest.getIsActive())
                .totalGates(terminalRequest.getTotalGates())
                .gates(null)
                .airport(null)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .flights(null)
                .build();

        Terminal newTerminal = terminalRepository.save(terminal);

        for(String str : terminalRequest.getTerminalTypes()) {

            try {

                TerminalTypeEnum typeEnum = TerminalTypeEnum.valueOf(str.toUpperCase());
                terminalTypeRepository.findByTerminalType(typeEnum)
                        .ifPresent(newTerminal.getTerminalTypes()::add);

            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

        }

        Terminal updatedTerminal = terminalRepository.save(newTerminal);

        return terminalResponse.buildTerminalResponse(updatedTerminal);

    }

}
