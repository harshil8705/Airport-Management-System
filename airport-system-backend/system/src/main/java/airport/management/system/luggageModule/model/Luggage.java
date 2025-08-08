package airport.management.system.luggageModule.model;

import airport.management.system.flightModule.model.Flight;
import airport.management.system.passengerModule.model.Passenger;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Luggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long luggageId;

    @NotBlank(message = "Luggage Tag is required")
    private String luggageTag;

    @NotNull(message = "Weight is Mandatory")
    private Double weightInKg;

    @NotNull
    private Boolean isFragile;

    private Boolean isLost = false;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "passenger_fk_id")
    private Passenger passenger;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "flight_fk_id")
    private Flight flight;

}
