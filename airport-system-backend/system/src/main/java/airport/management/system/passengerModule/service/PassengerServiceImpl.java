package airport.management.system.passengerModule.service;

import airport.management.system.passengerModule.repository.GenderRepository;
import airport.management.system.passengerModule.repository.GovtIdRepository;
import airport.management.system.passengerModule.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GovtIdRepository govtIdRepository;



}
