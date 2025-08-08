package airport.management.system.flightModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftMaintenanceId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MaintenanceStatusEnum maintenanceStatus;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "aircraft_fk_id")
    private Aircraft aircraft;

}
