package airport.management.system.airportModule.repository;

import airport.management.system.airportModule.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Long, Airport> {



}
