package airport.management.system.passengerModule.controller;

import airport.management.system.configuration.AppConstants;
import airport.management.system.passengerModule.request.PassengerRequest;
import airport.management.system.passengerModule.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/admin/get-passenger/first-name/{firstName}")
    public ResponseEntity<List<?>> getPassengerByFirstName(
            @PathVariable String firstName,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PASSENGER_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(passengerService.getPassengerByFirstName(firstName, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/admin/get-passenger/gender/{gender}")
    public ResponseEntity<List<?>> getPassengerByGender(
            @PathVariable String gender,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_PASSENGER_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder
    ) {

        return new ResponseEntity<>(passengerService.getPassengerByGender(gender, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-passenger/email/{email}")
    public ResponseEntity<?> getPassengerByEmail(@PathVariable String email) {

        return new ResponseEntity<>(passengerService.getPassengerByEmail(email), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-passenger/phone-number/{phoneNumber}")
    public ResponseEntity<?> getPassengerByPhoneNumber(@PathVariable String phoneNumber) {

        return new ResponseEntity<>(passengerService.getPassengerByPhoneNumber(phoneNumber), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-passenger/passport-number/{passportNumber}")
    public ResponseEntity<?> getPassengerByPassportNumber(@PathVariable String passportNumber) {

        return new ResponseEntity<>(passengerService.getPassengerByPassportNumber(passportNumber), HttpStatus.FOUND);

    }

    @PutMapping("/public/update-passenger/passenger-id/{passengerId}")
    public ResponseEntity<?> updatePassengerById(@PathVariable Long passengerId, @RequestBody PassengerRequest passengerRequest) {

        return new ResponseEntity<>(passengerService.updatePassengerById(passengerId, passengerRequest), HttpStatus.OK);

    }

    @DeleteMapping("/admin/delete-passenger/passenger-id/{passengerId}")
    public ResponseEntity<?> deletePassengerById(@PathVariable Long passengerId) {

        return new ResponseEntity<>(passengerService.deletePassengerById(passengerId), HttpStatus.OK);

    }

    @GetMapping("/public/get-passenger-details/passenger-id/{passengerId}")
    public ResponseEntity<?> getCompletePassengerDetails(@PathVariable Long passengerId) {

        return new ResponseEntity<>(passengerService.getCompletePassengerDetails(passengerId), HttpStatus.FOUND);

    }

}
