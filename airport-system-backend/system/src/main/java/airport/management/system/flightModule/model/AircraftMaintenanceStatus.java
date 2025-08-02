package airport.management.system.flightModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AircraftMaintenanceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftMaintenanceId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private MaintenanceStatus maintenanceStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "aircraftMaintenanceStatus", cascade = CascadeType.ALL)
    private Aircraft aircraft;

}
