package airport.management.system.airportModule.response;

import airport.management.system.airportModule.model.AirportType;
import lombok.*;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AirportType> airportTypes;

}
