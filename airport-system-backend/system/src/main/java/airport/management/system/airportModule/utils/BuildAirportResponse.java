package airport.management.system.airportModule.utils;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.airportModule.response.AirportResponse;
import org.springframework.stereotype.Component;

@Component
public class BuildAirportResponse {

    public AirportResponse buildAirportResponse(Airport airport) {

        return AirportResponse.builder()
                .airportName(airport.getAirportName())
                .airportId(airport.getAirportId())
                .city(airport.getCity())
                .country(airport.getCountry())
                .airportTypes(airport.getAirportTypes())
                .totalTerminals(airport.getTerminals().isEmpty() ? 0 : airport.getTerminals().size())
                .totalGates(airport.getGates().isEmpty() ? 0 : airport.getGates().size())
                .totalStaff(airport.getStaff().isEmpty() ? 0 : airport.getStaff().size())
                .build();

    }

}
