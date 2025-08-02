package airport.management.system.staffModule.model;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.flightModule.model.Flight;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
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

    @NotBlank
    private LocalDate dateOfJoining;

    @NotBlank
    private LocalDate dateOfBirth;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "staff_roles_fk_id")
    private StaffRoles staffRoles;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "staff_states_fk_id")
    private StaffStates staffStates;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "assigned_flight_fk_id")
    private Flight assignedFlight;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "assigned_airport_fk_id")
    private Airport assignedAirport;

}
