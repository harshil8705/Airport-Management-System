package airport.management.system.passengerModule.service;

import airport.management.system.exceptionModule.ApiException;
import airport.management.system.passengerModule.model.*;
import airport.management.system.passengerModule.repository.GenderRepository;
import airport.management.system.passengerModule.repository.GovtIdRepository;
import airport.management.system.passengerModule.repository.PassengerRepository;
import airport.management.system.passengerModule.request.PassengerRequest;
import airport.management.system.passengerModule.util.PassengerResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GovtIdRepository govtIdRepository;

    @Autowired
    private PassengerResponseBuilder passengerResponseBuilder;

    @Override
    public Object addNewPassenger(PassengerRequest passenger) {

        GenderEnum genderEnum = GenderEnum.valueOf(passenger.getGender().toUpperCase());
        Gender gender = genderRepository.findByGender(genderEnum);
        if (gender == null) {
            throw new ApiException("No gender found by the gender: " + passenger.getGender());
        }

        GovtIdEnum govtIdEnum = GovtIdEnum.valueOf(passenger.getGovtId().toUpperCase());
        GovtId govtId = govtIdRepository.findByGovtIdEnum(govtIdEnum);
        if (govtId == null) {
            throw new ApiException("No govtId found by the govtId: " + govtId);
        }

        Passenger newPassenger = Passenger.builder()
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .dateOfBirth(passenger.getDateOfBirth())
                .email(passenger.getEmail())
                .phoneNumber(passenger.getPhoneNumber())
                .address(null)
                .passportNumber(passenger.getPassportNumber())
                .passportExpiryDate(passenger.getPassportExpiryDate())
                .nationality(passenger.getNationality())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isActive(true)
                .reservations(new ArrayList<>())
                .luggage(new ArrayList<>())
                .flight(null)
                .gender(gender)
                .govtId(govtId)
                .build();

        return passengerResponseBuilder.buildPassengerResponse(passengerRepository.save(newPassenger));

    }

    @Override
    public Object getPassengerById(Long passengerId) {

        Passenger existingPassenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ApiException("No passenger found by passengerId: " + passengerId));

        return passengerResponseBuilder.buildPassengerResponse(existingPassenger);

    }
}
