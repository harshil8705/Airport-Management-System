package airport.management.system.staffModule.model;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.flightModule.model.Flight;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    @NotBlank
    @Length(max = 120)
    private String fullName;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(unique = true)
    private String phoneNumber;

    @NotNull
    private LocalDate dateOfJoining;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "staff_roles_fk_id")
    private StaffRoles staffRoles;

    @NotNull
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "staff_status_fk_id")
    private StaffStatus staffStatus;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "assigned_flight_fk_id")
    private Flight assignedFlight;

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "assigned_airport_fk_id")
    private Airport assignedAirport;

}
