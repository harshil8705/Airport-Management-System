package airport.management.system.passengerModule.util;

import airport.management.system.passengerModule.model.GovtId;
import airport.management.system.passengerModule.model.GovtIdEnum;
import airport.management.system.passengerModule.repository.GovtIdRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GovtIdDataInitializer {

    @Autowired
    private GovtIdRepository govtIdRepository;

    @PostConstruct
    public void insertGovtIdTypes() {

        if (govtIdRepository.count() == 0) {

            GovtId aadhar = GovtId.builder()
                    .govtId(1L)
                    .govtIdEnum(GovtIdEnum.AADHAR)
                    .build();
            govtIdRepository.save(aadhar);

            GovtId panCard = GovtId.builder()
                    .govtId(2L)
                    .govtIdEnum(GovtIdEnum.PAN_CARD)
                    .build();
            govtIdRepository.save(panCard);

            System.out.println("GovtId Types Initialized.");

        } else {
            System.out.println("GovtId Types already exists. Skipping Initialization.");
        }

    }

}
