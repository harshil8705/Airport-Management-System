package airport.management.system.staffModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffStatesId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StaffStatusEnum staffStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "staffStates", cascade = CascadeType.ALL)
    private Staff staff;

}
