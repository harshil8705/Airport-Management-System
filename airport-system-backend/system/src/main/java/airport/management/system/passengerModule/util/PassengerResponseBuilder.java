package airport.management.system.passengerModule.util;

import airport.management.system.passengerModule.model.Passenger;
import airport.management.system.passengerModule.response.PassengerResponse;
import org.springframework.stereotype.Component;

@Component
public class PassengerResponseBuilder {

    public PassengerResponse buildPassengerResponse(Passenger passenger) {

        return PassengerResponse.builder()
                .passengerId(passenger.getPassengerId())
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .gender(passenger.getGender())
                .dateOfBirth(passenger.getDateOfBirth())
                .email(passenger.getEmail())
                .phoneNumber(passenger.getPhoneNumber())
                .passportNumber(passenger.getPassportNumber())
                .passportExpiryDate(passenger.getPassportExpiryDate())
                .nationality(passenger.getNationality())
                .govtId(passenger.getGovtId())
                .createdAt(passenger.getCreatedAt())
                .updatedAt(passenger.getUpdatedAt())
                .isActive(passenger.isActive())
                .build();

    }

}
