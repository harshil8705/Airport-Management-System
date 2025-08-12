package airport.management.system.airportModule.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportTypeId;

    @Enumerated(EnumType.STRING)
    private AirportTypeEnum airportType;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "airport_fk_id")
    private Airport airport;

}
