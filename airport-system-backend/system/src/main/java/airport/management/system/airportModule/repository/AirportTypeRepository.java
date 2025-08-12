package airport.management.system.airportModule.repository;

import airport.management.system.airportModule.model.AirportType;
import airport.management.system.airportModule.model.AirportTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportTypeRepository extends JpaRepository<AirportType, Long> {

    Optional<AirportType> findByAirportType(AirportTypeEnum typeEnum);

}
