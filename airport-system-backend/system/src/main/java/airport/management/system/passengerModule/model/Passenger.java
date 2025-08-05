package airport.management.system.passengerModule.model;

import airport.management.system.AddressModule.model.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    @NotBlank
    @Length(max = 150)
    private String firstName;

    @NotBlank
    @Length(max = 150)
    private String lastName;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "passenger_gender_fk_id")
    private PassengerGender passengerGender;

    @NotBlank
    private LocalDate dateOfBirth;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
    private Address address;

    @NotBlank
    private String passportNumber;

    @NotBlank
    private LocalDate passportExpiryDate;

    @NotBlank
    private String nationality;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "passenger_govt_fk_id")
    private PassengerGovtId passengerGovtId;

    @NotBlank
    private LocalDateTime createdAt;

    @NotBlank
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isActive;

}
