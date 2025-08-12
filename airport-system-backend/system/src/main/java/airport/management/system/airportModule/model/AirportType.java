package airport.management.system.airportModule.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportType {

    @Id
    private Long airportTypeId;

    @Enumerated(EnumType.STRING)
    private AirportTypeEnum airportType;

}
