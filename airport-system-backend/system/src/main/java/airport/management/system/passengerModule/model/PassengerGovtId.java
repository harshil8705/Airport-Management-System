package airport.management.system.passengerModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerGovtId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerGovtId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private GovtId govtId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "passengerGovtId", cascade = CascadeType.ALL)
    private Passenger passenger;

}
