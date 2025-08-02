package airport.management.system.flightModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightStateId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "flightState", cascade = CascadeType.ALL)
    private Flight flight;

}
