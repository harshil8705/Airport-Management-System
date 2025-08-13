package airport.management.system.airportModule.service;

import airport.management.system.airportModule.request.AirportRequest;

import java.util.List;
import java.util.Set;

public interface AirportService {

    Object addNewAirport(AirportRequest airportRequest);

    Object getAirportById(Long airportId);

    List<?> getAirportByName(String airportName, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<?> getAirportByCity(String city, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<?> getAirportByCountry(String country, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<?> getAllAirports(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object updateAirportById(Long airportId, AirportRequest airportRequest);

    Object deleteAirportById(Long airportId);

    Object getCompleteAirportDetails(Long airportId);

    Object removeTypeOfAirportById(Long airportId, Set<String> airportTypes);

}
