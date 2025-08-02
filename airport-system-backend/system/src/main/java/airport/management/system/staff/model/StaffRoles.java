package airport.management.system.staff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Enumerated(EnumType.STRING)
    private StaffRole staffRole;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "staffRoles", cascade = CascadeType.ALL)
    private Staff staff;

}
