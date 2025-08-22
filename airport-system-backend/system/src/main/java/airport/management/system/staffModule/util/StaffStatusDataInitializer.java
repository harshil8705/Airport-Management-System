package airport.management.system.staffModule.util;

import airport.management.system.staffModule.model.StaffStatus;
import airport.management.system.staffModule.model.StaffStatusEnum;
import airport.management.system.staffModule.repository.StaffStatusRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StaffStatusDataInitializer {

    @Autowired
    private StaffStatusRepository staffStatusRepository;

    @PostConstruct
    public void insertStaffStatus() {

        if (staffStatusRepository.count() == 0) {

            StaffStatus active = StaffStatus.builder()
                    .staffStatusId(1L)
                    .staffStatus(StaffStatusEnum.ACTIVE)
                    .build();
            staffStatusRepository.save(active);

            StaffStatus onDuty = StaffStatus.builder()
                    .staffStatusId(2L)
                    .staffStatus(StaffStatusEnum.ON_DUTY)
                    .build();
            staffStatusRepository.save(onDuty);

            StaffStatus offDuty = StaffStatus.builder()
                    .staffStatusId(3L)
                    .staffStatus(StaffStatusEnum.OFF_DUTY)
                    .build();
            staffStatusRepository.save(offDuty);

            StaffStatus onLeave = StaffStatus.builder()
                    .staffStatusId(4L)
                    .staffStatus(StaffStatusEnum.ON_LEAVE)
                    .build();
            staffStatusRepository.save(onLeave);

            StaffStatus retired = StaffStatus.builder()
                    .staffStatusId(5L)
                    .staffStatus(StaffStatusEnum.RETIRED)
                    .build();
            staffStatusRepository.save(retired);

            StaffStatus terminated = StaffStatus.builder()
                    .staffStatusId(6L)
                    .staffStatus(StaffStatusEnum.TERMINATED)
                    .build();
            staffStatusRepository.save(terminated);

            System.out.println("Staff Status Initialized.");

        } else {
            System.out.println("Staff Status already exists. Skipping Initialization.");
        }

    }

}
