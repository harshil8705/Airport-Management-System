package airport.management.system.terminalModule.util;

import airport.management.system.terminalModule.model.TerminalType;
import airport.management.system.terminalModule.model.TerminalTypeEnum;
import airport.management.system.terminalModule.repository.TerminalTypeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TerminalTypeInitializer {

    @Autowired
    private TerminalTypeRepository terminalTypeRepository;

    @PostConstruct
    public void insertTerminalTypes() {

        if (terminalTypeRepository.count() == 0) {

            TerminalType international = TerminalType.builder()
                    .terminalTypeId(1L)
                    .terminalType(TerminalTypeEnum.INTERNATIONAL)
                    .build();
            terminalTypeRepository.save(international);

            TerminalType domestic = TerminalType.builder()
                    .terminalTypeId(2L)
                    .terminalType(TerminalTypeEnum.DOMESTIC)
                    .build();
            terminalTypeRepository.save(domestic);

            TerminalType cargo = TerminalType.builder()
                    .terminalTypeId(3L)
                    .terminalType(TerminalTypeEnum.CARGO)
                    .build();
            terminalTypeRepository.save(cargo);

            System.out.println("Terminal Types Initialized.");
        } else {
            System.out.println("Terminal Types already exists. Skipping Initialization.");
        }

    }

}
