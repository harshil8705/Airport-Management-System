package airport.management.system.passengerModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GovtId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerGovtId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GovtIdEnum govtId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "passengerGovtId", cascade = CascadeType.ALL)
    private Passenger passenger;

}
