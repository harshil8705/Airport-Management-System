package airport.management.system.staffModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffStates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffStatesId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private StaffStatus staffStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "staffStates", cascade = CascadeType.ALL)
    private Staff staff;

}
