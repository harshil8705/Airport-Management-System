package airport.management.system.terminalModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalType {

    @Id
    private Long terminalTypeId;

    @Enumerated(EnumType.STRING)
    private TerminalTypeEnum terminalType;

}
