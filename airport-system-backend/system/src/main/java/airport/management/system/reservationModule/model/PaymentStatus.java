package airport.management.system.reservationModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentStatusId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;

    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @OneToOne(mappedBy = "paymentStatus", cascade = CascadeType.ALL)
    private Reservation reservation;

}
