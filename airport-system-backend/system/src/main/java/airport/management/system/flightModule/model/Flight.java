package airport.management.system.flightModule.model;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.reservationModule.model.Reservation;
import airport.management.system.staffModule.model.Staff;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @NotBlank
    @Length(max = 50)
    @Column(unique = true)
    private String flightName;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "aircraft_fk_id")
    private Aircraft aircraft;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "source_airport_fk_id")
    private Airport sourceAirport;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "destination_airport_fk_id")
    private Airport destinationAirport;

    @NotBlank
    private boolean status;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "flight_state_fk_id")
    private FlightStatus flightStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "assignedFlight", cascade = CascadeType.ALL)
    private List<Staff> staff;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}
