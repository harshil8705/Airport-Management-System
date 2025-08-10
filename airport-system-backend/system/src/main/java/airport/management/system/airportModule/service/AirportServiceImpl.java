package airport.management.system.airportModule.service;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.airportModule.repository.AirportRepository;
import airport.management.system.airportModule.request.AirportRequest;
import airport.management.system.airportModule.response.AirportResponse;
import airport.management.system.exceptionModule.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Airport existingAirport = airportRepository.findById(airportId)
                .orElseThrow(() -> new ApiException("No airport found by the airportId: " + airportId));

        return AirportResponse.builder()
                .airportId(existingAirport.getAirportId())
                .country(existingAirport.getCountry())
                .city(existingAirport.getCity())
                .airportName(existingAirport.getAirportName())
                .build();

    }

    @Override
    public List<?> getAirportByName(String airportName, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<Airport> airportPage = airportRepository.findByAirportNameContainingIgnoreCase(airportName, pageDetails);
        List<Airport> airports = airportPage.getContent();

        if (airports.isEmpty()) {
            throw new ApiException("No Airport found by the name: " + airportName);
        }

        return airports.stream()
                .map(airport -> AirportResponse.builder()
                        .airportId(airport.getAirportId())
                        .airportName(airport.getAirportName())
                        .country(airport.getCountry())
                        .city(airport.getCity())
                        .build()
                )
                .toList();

    }

    @Override
    public List<?> getAirportByCity(String city, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Airport> airportPage = airportRepository.findByCityContainingIgnoreCase(city, pageDetails);

        List<Airport> airports = airportPage.getContent();

        if (airports.isEmpty()) {
            throw new ApiException("No Airport found by the city: " + city);
        }

        return airports.stream()
                .map(airport -> AirportResponse.builder()
                        .airportId(airport.getAirportId())
                        .city(airport.getCity())
                        .country(airport.getCountry())
                        .airportName(airport.getAirportName())
                        .build()
                )
                .toList();

    }

    @Override
    public List<?> getAirportByCountry(String country, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Airport> airportPage = airportRepository.findByCountryContainingIgnoreCase(country, pageDetails);

        List<Airport> airports = airportPage.getContent();

        if (airports.isEmpty()) {
            throw new ApiException("No Airport found by the country: " + country);
        }

        return airports.stream()
                .map(airport -> AirportResponse.builder()
                        .airportId(airport.getAirportId())
                        .city(airport.getCity())
                        .country(airport.getCountry())
                        .airportName(airport.getAirportName())
                        .build()
                )
                .toList();

    }

    @Override
    public List<?> getAllAirports(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Airport> airportPage = airportRepository.findAll(pageDetails);

        List<Airport> airports = airportPage.getContent();

        if (airports.isEmpty()) {
            throw new ApiException("No Airport found");
        }

        return airports.stream()
                .map(airport -> AirportResponse.builder()
                        .airportId(airport.getAirportId())
                        .city(airport.getCity())
                        .country(airport.getCountry())
                        .airportName(airport.getAirportName())
                        .build()
                )
                .toList();

    }

    @Override
    public Object updateAirportById(Long airportId, AirportRequest airportRequest) {

        Airport existingAirport = airportRepository.findById(airportId)
                .orElseThrow(() -> new ApiException("No airport found by the airportId: " + airportId));

        existingAirport.setAirportName(airportRequest.getAirportName());
        existingAirport.setCity(airportRequest.getCity());
        existingAirport.setCountry(airportRequest.getCountry());

        Airport updatedAirport = airportRepository.save(existingAirport);

        return AirportResponse.builder()
                .airportId(updatedAirport.getAirportId())
                .airportName(updatedAirport.getAirportName())
                .city(updatedAirport.getCity())
                .country(updatedAirport.getCountry())
                .build();
    }

    @Override
    public Object deleteAirportById(Long airportId) {

        Airport airportToDelete = airportRepository.findById(airportId)
                .orElseThrow(() -> new ApiException("No airport found by the airportId: " + airportId));

        airportRepository.delete(airportToDelete);

        return "Airport with airportId: " + airportId + " deleted Successfully.";

    }

}
