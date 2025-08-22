package airport.management.system.staffModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffRoleId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StaffRolesEnum staffRoles;

}
