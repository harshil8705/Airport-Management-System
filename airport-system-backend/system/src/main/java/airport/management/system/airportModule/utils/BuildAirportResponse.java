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
                .build();

    }

}
