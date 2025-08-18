package airport.management.system.gateModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GateStatus {

    @Id
    private Long gateStatusId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GateStatusEnum gateStatus;

}
