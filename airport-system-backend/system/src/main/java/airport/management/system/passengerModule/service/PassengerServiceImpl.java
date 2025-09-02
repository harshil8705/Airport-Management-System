package airport.management.system.passengerModule.service;

import airport.management.system.exceptionModule.ApiException;
import airport.management.system.passengerModule.model.*;
import airport.management.system.passengerModule.repository.GenderRepository;
import airport.management.system.passengerModule.repository.GovtIdRepository;
import airport.management.system.passengerModule.repository.PassengerRepository;
import airport.management.system.passengerModule.request.PassengerRequest;
import airport.management.system.passengerModule.util.PassengerResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<?> getPassengerByFirstName(String firstName, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Passenger> passengerPage = passengerRepository.findByFirstNameContainingIgnoreCase(firstName, pageDetails);

        List<Passenger> passengers = passengerPage.getContent();
        if (passengers.isEmpty()) {
            throw new ApiException("No passengers found by firstName: " + firstName);
        }

        return passengers.stream().map(passenger -> passengerResponseBuilder.buildPassengerResponse(passenger)).toList();

    }

    @Override
    public List<?> getPassengerByGender(String gender, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        GenderEnum typeEnum = GenderEnum.valueOf(gender.toUpperCase());
        Gender gender1 = genderRepository.findByGender(typeEnum);
        if (gender1 == null) {
            throw new ApiException("No gender found by gender: " + gender);
        }

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Passenger> passengerPage = passengerRepository.findByGender(gender1, pageDetails);

        List<Passenger> passengers = passengerPage.getContent();
        if (passengers.isEmpty()) {
            throw new ApiException("No passengers found by gender: " + gender1.getGender());
        }

        return passengers.stream().map(passenger -> passengerResponseBuilder.buildPassengerResponse(passenger)).toList();

    }

    @Override
    public Object getPassengerByEmail(String email) {

        Passenger passenger = passengerRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException("No passenger found by email: " + email));

        return passengerResponseBuilder.buildPassengerResponse(passenger);

    }

    @Override
    public Object getPassengerByPhoneNumber(String phoneNumber) {

        Passenger passenger = passengerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ApiException("No passenger found by phoneNumber: " + phoneNumber));

        return passengerResponseBuilder.buildPassengerResponse(passenger);

    }

    @Override
    public Object getPassengerByPassportNumber(String passportNumber) {

        Passenger passenger = passengerRepository.findByPassportNumber(passportNumber)
                .orElseThrow(() -> new ApiException("No passenger found by passportNumber: " + passportNumber));

        return passengerResponseBuilder.buildPassengerResponse(passenger);

    }

    @Override
    public Object updatePassengerById(Long passengerId, PassengerRequest passengerRequest) {

        Passenger oldPassenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ApiException("No passenger found by passengerId: " + passengerId));

        GenderEnum genderEnum = GenderEnum.valueOf(passengerRequest.getGender().toUpperCase());
        Gender gender = genderRepository.findByGender(genderEnum);
        if (gender == null) {
            throw new ApiException("No gender found by gender: " + passengerRequest.getGender());
        }

        GovtIdEnum govtIdEnum = GovtIdEnum.valueOf(passengerRequest.getGovtId().toUpperCase());
        GovtId govtId = govtIdRepository.findByGovtIdEnum(govtIdEnum);
        if (govtId == null) {
            throw new ApiException("No govtId found by govtId: " + passengerRequest.getGovtId());
        }

        oldPassenger.setFirstName(passengerRequest.getFirstName());
        oldPassenger.setLastName(passengerRequest.getLastName());
        oldPassenger.setDateOfBirth(passengerRequest.getDateOfBirth());
        oldPassenger.setEmail(passengerRequest.getEmail());
        oldPassenger.setPhoneNumber(passengerRequest.getPhoneNumber());
        oldPassenger.setPassportNumber(passengerRequest.getPassportNumber());
        oldPassenger.setPassportExpiryDate(passengerRequest.getPassportExpiryDate());
        oldPassenger.setNationality(passengerRequest.getNationality());
        oldPassenger.setUpdatedAt(LocalDateTime.now());
        oldPassenger.setGender(gender);
        oldPassenger.setGovtId(govtId);

        return passengerResponseBuilder.buildPassengerResponse(passengerRepository.save(oldPassenger));

    }

    @Override
    public Object deletePassengerById(Long passengerId) {

        Passenger passengerToDelete = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ApiException("No passenger found by passengerId: " + passengerId));

        passengerRepository.delete(passengerToDelete);

        return "Passenger by passengerId: " + passengerId + " deleted successfully.";

    }

    @Override
    public Object getCompletePassengerDetails(Long passengerId) {

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ApiException("No passenger found by passengerId: " + passengerId));

        return passengerResponseBuilder.buildPassengerResponse2(passenger);

    }

}
