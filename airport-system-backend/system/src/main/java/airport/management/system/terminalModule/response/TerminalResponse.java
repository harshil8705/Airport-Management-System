package airport.management.system.terminalModule.response;

import airport.management.system.terminalModule.model.TerminalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalResponse {

    private Long terminalId;
    private String terminalCode;
    private String location;
    private Integer totalGates;
    private Boolean isActive;

    @Builder.Default
    private Set<TerminalType> terminalTypes = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
