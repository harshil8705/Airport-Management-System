package airport.management.system.staffModule.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffRequest {

    private String fullName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String staffRoles;
    private String staffStatus;

}
