package airport.management.system.terminalModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terminalTypeId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TerminalTypeEnum terminalTypeEnum;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "terminalType", cascade = CascadeType.ALL)
    private Terminal terminal;

}
