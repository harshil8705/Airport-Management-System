package airport.management.system.airportModule.utils;

import airport.management.system.airportModule.model.AirportType;
import airport.management.system.airportModule.model.AirportTypeEnum;
import airport.management.system.airportModule.repository.AirportTypeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportTypeInitializer {

    @Autowired
    private AirportTypeRepository airportTypeRepository;

    @PostConstruct
    public void insertAirportTypes() {

        if (airportTypeRepository.count() == 0) {

            AirportType international = AirportType.builder()
                    .airportTypeId(1L)
                    .airportType(AirportTypeEnum.INTERNATIONAL)
                    .build();
            airportTypeRepository.save(international);

            AirportType domestic = AirportType.builder()
                    .airportTypeId(2L)
                    .airportType(AirportTypeEnum.DOMESTIC)
                    .build();
            airportTypeRepository.save(domestic);

            AirportType cargo = AirportType.builder()
                    .airportTypeId(3L)
                    .airportType(AirportTypeEnum.CARGO)
                    .build();
            airportTypeRepository.save(cargo);

            System.out.println("Airport Types Initialized.");
        } else {
            System.out.println("Airport Types already exists. Skipping Initialization.");
        }

    }

}
