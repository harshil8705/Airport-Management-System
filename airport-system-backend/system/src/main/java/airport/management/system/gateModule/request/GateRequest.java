package airport.management.system.gateModule.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GateRequest {

    @NotNull
    private String gateCode;

    @NotNull
    private String gateStatus;

    @NotNull
    private LocalTime openTime;

    @NotNull
    private LocalTime closeTime;

}
