package airport.management.system.flightModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;

    @NotBlank
    private Integer aircraftSeats;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
    private Set<AircraftMaintenanceStatus> aircraftMaintenanceStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "aircraft", cascade = CascadeType.ALL)
    private Flight flight;

    @NotBlank
    private LocalDateTime arrivalTime;

    @NotBlank
    private LocalDateTime departureTime;

}
