package airport.management.system.passengerModule.service;

import airport.management.system.passengerModule.request.PassengerRequest;

import java.util.List;

public interface PassengerService {

    Object addNewPassenger(PassengerRequest passenger);

    Object getPassengerById(Long passengerId);

    List<?> getPassengerByFirstName(String firstName, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<?> getPassengerByGender(String gender, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object getPassengerByEmail(String email);

    Object getPassengerByPhoneNumber(String phoneNumber);

    Object getPassengerByPassportNumber(String passportNumber);

    Object updatePassengerById(Long passengerId, PassengerRequest passengerRequest);

    Object deletePassengerById(Long passengerId);

    Object getCompletePassengerDetails(Long passengerId);

}
