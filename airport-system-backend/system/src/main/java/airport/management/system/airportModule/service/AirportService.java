package airport.management.system.airportModule.service;

import airport.management.system.airportModule.request.AirportRequest;

public interface AirportService {

    Object addNewAirport(AirportRequest airportRequest);

    Object getAirportById(Long airportId);

}
