package airport.management.system.airportModule.request;

import airport.management.system.airportModule.model.AirportTypeEnum;
import airport.management.system.flightModule.model.Flight;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportRequest {

    private Long airportId;

    @NotBlank
    @Column(unique = true)
    private String airportName;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    private List<AirportTypeEnum> airportType;

}
