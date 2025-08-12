package airport.management.system.airportModule.service;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.airportModule.model.AirportTypeEnum;
import airport.management.system.airportModule.repository.AirportRepository;
import airport.management.system.airportModule.repository.AirportTypeRepository;
import airport.management.system.airportModule.request.AirportRequest;
import airport.management.system.airportModule.response.AirportResponse2;
import airport.management.system.airportModule.utils.BuildAirportResponse;
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

    @Autowired
    private BuildAirportResponse airportResponse;

    @Autowired
    private AirportTypeRepository airportTypeRepository;

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

        for(String str : airportRequest.getAirportType()) {

            try {

                AirportTypeEnum typeEnum = AirportTypeEnum.valueOf(str.toUpperCase());
                airportTypeRepository.findByAirportType(typeEnum)
                        .ifPresent(newAirport.getAirportTypes()::add);

            } catch (RuntimeException e) {

                throw new RuntimeException(e);

            }

        }

        Airport updatedAirport = airportRepository.save(newAirport);

        return airportResponse.buildAirportResponse(updatedAirport);

    }

    @Override
    public Object getAirportById(Long airportId) {

        Airport existingAirport = airportRepository.findById(airportId)
                .orElseThrow(() -> new ApiException("No airport found by the airportId: " + airportId));

        return airportResponse.buildAirportResponse(existingAirport);

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
                .map(airport -> airportResponse.buildAirportResponse(airport))
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
                .map(airport -> airportResponse.buildAirportResponse(airport))
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
                .map(airport -> airportResponse.buildAirportResponse(airport))
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
                .map(airport -> airportResponse.buildAirportResponse(airport))
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

        if (!airportRequest.getAirportType().isEmpty()) {
            for(String str : airportRequest.getAirportType()) {

                try {

                    AirportTypeEnum typeEnum = AirportTypeEnum.valueOf(str.toUpperCase());
                    airportTypeRepository.findByAirportType(typeEnum)
                            .ifPresent(updatedAirport.getAirportTypes()::add);

                } catch (RuntimeException e) {

                    throw new RuntimeException(e);

                }

            }
        }

        Airport newlyUpdatedAirport = airportRepository.save(updatedAirport);

        return airportResponse.buildAirportResponse(newlyUpdatedAirport);
    }

    @Override
    public Object deleteAirportById(Long airportId) {

        Airport airportToDelete = airportRepository.findById(airportId)
                .orElseThrow(() -> new ApiException("No airport found by the airportId: " + airportId));

        airportRepository.delete(airportToDelete);

        return "Airport with airportId: " + airportId + " deleted Successfully.";

    }

    @Override
    public Object getCompleteAirportDetails(Long airportId) {

        Airport existingAirport = airportRepository.findById(airportId)
                .orElseThrow(() -> new ApiException("No airport found by the airportId: " + airportId));

        return AirportResponse2.builder()
                .airportId(existingAirport.getAirportId())
                .airportName(existingAirport.getAirportName())
                .gates(existingAirport.getGates().isEmpty() ? null : existingAirport.getGates())
                .country(existingAirport.getCountry())
                .terminals(existingAirport.getTerminals().isEmpty() ? null : existingAirport.getTerminals())
                .incomingFlight(existingAirport.getIncomingFlight().isEmpty() ? null : existingAirport.getIncomingFlight())
                .outgoingFlight(existingAirport.getOutgoingFlight().isEmpty() ? null : existingAirport.getOutgoingFlight())
                .city(existingAirport.getCity())
                .airportTypes(existingAirport.getAirportTypes().isEmpty() ? null : existingAirport.getAirportTypes())
                .build();

    }

}
