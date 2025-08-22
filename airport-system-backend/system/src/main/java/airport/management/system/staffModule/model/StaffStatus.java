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
    private Long staffStatusId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StaffStatusEnum staffStatus;

}
