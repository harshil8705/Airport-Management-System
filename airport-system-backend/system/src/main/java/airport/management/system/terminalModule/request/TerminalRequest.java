package airport.management.system.terminalModule.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalRequest {

    @NotBlank
    private String terminalCode;

    @NotBlank
    private String location;

    @NotNull
    private Boolean isActive;

    private Set<String> terminalTypes;

}
