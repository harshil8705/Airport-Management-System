package airport.management.system.gateModule.util;

import airport.management.system.gateModule.model.GateStatus;
import airport.management.system.gateModule.model.GateStatusEnum;
import airport.management.system.gateModule.repository.GateStatusRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GateStatusInitializer {

    @Autowired
    private GateStatusRepository gateStatusRepository;

    @PostConstruct
    public void insertGateTypes() {

        if(gateStatusRepository.count() == 0) {

            GateStatus available = GateStatus.builder()
                    .gateStatusId(1L)
                    .gateStatus(GateStatusEnum.AVAILABLE)
                    .build();
            gateStatusRepository.save(available);

            GateStatus maintenance = GateStatus.builder()
                    .gateStatusId(2L)
                    .gateStatus(GateStatusEnum.MAINTENANCE)
                    .build();
            gateStatusRepository.save(maintenance);

            GateStatus occupied = GateStatus.builder()
                    .gateStatusId(3L)
                    .gateStatus(GateStatusEnum.OCCUPIED)
                    .build();
            gateStatusRepository.save(occupied);

            GateStatus closed = GateStatus.builder()
                    .gateStatusId(4L)
                    .gateStatus(GateStatusEnum.CLOSED)
                    .build();
            gateStatusRepository.save(closed);

            System.out.println("Gate Status Initialized");
        } else {
            System.out.println("Gate Status already exists. Skipping Initialization.");
        }

    }

}
