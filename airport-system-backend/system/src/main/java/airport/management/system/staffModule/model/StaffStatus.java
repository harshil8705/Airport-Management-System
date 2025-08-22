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
    private Long staffStatusId;

    @Enumerated(EnumType.STRING)
    private StaffStatusEnum staffStatus;

}
