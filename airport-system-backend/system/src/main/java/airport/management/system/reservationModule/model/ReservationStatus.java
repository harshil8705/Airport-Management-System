package airport.management.system.reservationModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationStatusId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReservationStatusEnum reservationStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "reservationStatus", cascade = CascadeType.ALL)
    private Reservation reservation;

}
