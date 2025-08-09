package airport.management.system.airportModule.service;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.airportModule.repository.AirportRepository;
import airport.management.system.airportModule.request.AirportRequest;
import airport.management.system.airportModule.response.AirportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Object addNewAirport(AirportRequest airportRequest) {

        Airport airport = Airport.builder()
                .airportName(airportRequest.getAirportName())
                .city(airportRequest.getCity())
                .country(airportRequest.getCountry())
                .staff(null)
                .gates(null)
                .outgoingFlight(null)
                .incomingFlight(null)
                .terminals(null)
                .build();

        Airport newAirport = airportRepository.save(airport);

        return AirportResponse.builder()
                .airportId(newAirport.getAirportId())
                .airportName(newAirport.getAirportName())
                .city(newAirport.getCity())
                .country(newAirport.getCountry())
                .build();

    }

    @Override
    public Object getAirportById(Long airportId) {

        return airportId;

    }

}
