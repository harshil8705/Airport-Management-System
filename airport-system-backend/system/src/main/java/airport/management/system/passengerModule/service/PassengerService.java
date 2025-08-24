package airport.management.system.passengerModule.service;

import airport.management.system.passengerModule.request.PassengerRequest;

public interface PassengerService {

    Object addNewPassenger(PassengerRequest passenger);

    Object getPassengerById(Long passengerId);

}
