package airport.management.system.passengerModule.controller;

import airport.management.system.passengerModule.request.PassengerRequest;
import airport.management.system.passengerModule.service.PassengerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/public/add-passenger")
    public ResponseEntity<?> addNewPassenger(@RequestBody PassengerRequest passenger) {

        return new ResponseEntity<>(passengerService.addNewPassenger(passenger), HttpStatus.CREATED);

    }

    @GetMapping("/public/get-passenger/passenger-id/{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long passengerId) {

        return new ResponseEntity<>(passengerService.getPassengerById(passengerId), HttpStatus.FOUND);

    }

}
