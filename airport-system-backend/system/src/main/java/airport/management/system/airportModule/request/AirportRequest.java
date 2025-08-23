package airport.management.system.airportModule.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportRequest {

    @NotBlank
    @Column(unique = true)
    private String airportName;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    private Set<String> airportType;

}
