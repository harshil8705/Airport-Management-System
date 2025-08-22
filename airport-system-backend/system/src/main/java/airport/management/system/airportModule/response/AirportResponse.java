package airport.management.system.airportModule.response;

import airport.management.system.airportModule.model.AirportType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportResponse {

    private Long airportId;
    private String airportName;
    private String city;
    private String country;
    private Integer totalTerminals;
    private Integer totalGates;

    @Builder.Default
    private Set<AirportType> airportTypes = new HashSet<>();

}
