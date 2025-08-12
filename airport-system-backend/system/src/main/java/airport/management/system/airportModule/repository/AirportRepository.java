package airport.management.system.airportModule.repository;

import airport.management.system.airportModule.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Page<Airport> findByAirportNameContainingIgnoreCase(String airportName, Pageable pageDetails);

    Page<Airport> findByCityContainingIgnoreCase(String city, Pageable pageDetails);

    Page<Airport> findByCountryContainingIgnoreCase(String country, Pageable pageDetails);

}
