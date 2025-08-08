package airport.management.system.flightModule.model;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.luggageModule.model.Luggage;
import airport.management.system.passengerModule.model.Passenger;
import airport.management.system.reservationModule.model.Reservation;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.terminalModule.model.Terminal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "aircraft_fk_id")
    private Aircraft aircraft;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "source_airport_fk_id")
    private Airport sourceAirport;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "destination_airport_fk_id")
    private Airport destinationAirport;

    @NotNull
    private boolean status;

    @NotNull
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

    @NotNull
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "gate_fk_id")
    private Gate gate;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "terminal_fk_id")
    private Terminal terminal;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Luggage> luggage;

    @NotNull
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "passenger_fk_id")
    private Passenger passenger;

}
