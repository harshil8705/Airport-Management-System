package airport.management.system.passengerModule.response;

import airport.management.system.addressModule.model.Address;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.luggageModule.model.Luggage;
import airport.management.system.passengerModule.model.Gender;
import airport.management.system.passengerModule.model.GovtId;
import airport.management.system.reservationModule.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerResponse2 {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String passportNumber;
    private LocalDate passportExpiryDate;
    private String nationality;
    private GovtId govtId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
    private Address address;
    private List<Reservation> reservations;
    private List<Luggage> luggage;
    private Flight flight;

}
