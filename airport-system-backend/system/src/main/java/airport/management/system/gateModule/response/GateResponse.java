package airport.management.system.gateModule.response;

import airport.management.system.gateModule.model.GateStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GateResponse {

    private Long gateId;
    private String gateCode;
    private GateStatus gateStatus;
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
