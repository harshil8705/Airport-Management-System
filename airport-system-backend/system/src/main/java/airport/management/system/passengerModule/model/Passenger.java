package airport.management.system.passengerModule.model;

import airport.management.system.addressModule.model.Address;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.luggageModule.model.Luggage;
import airport.management.system.reservationModule.model.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "gender_fk_id")
    private Gender gender;

    @NotNull
    private LocalDate dateOfBirth;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(unique = true)
    private String phoneNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
    private Address address;

    @NotBlank
    @Column(unique = true)
    private String passportNumber;

    @NotNull
    private LocalDate passportExpiryDate;

    @NotBlank
    private String nationality;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "govt_fk_id")
    private GovtId govtId;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private boolean isActive;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Luggage> luggage;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "", cascade = CascadeType.ALL)
    private Flight flight;

}