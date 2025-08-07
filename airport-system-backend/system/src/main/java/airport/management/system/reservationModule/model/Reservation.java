package airport.management.system.reservationModule.model;

import airport.management.system.flightModule.model.Flight;
import airport.management.system.passengerModule.model.Passenger;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @NotBlank
    private String seatNumber;

    @NotBlank
    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "passenger_fk_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_fk_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Flight flight;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "reservation_status_fk_id")
    private ReservationStatus reservationStatus;

    @OneToOne
    @JoinColumn(name = "payment_status_fk_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PaymentStatus paymentStatus;

}
