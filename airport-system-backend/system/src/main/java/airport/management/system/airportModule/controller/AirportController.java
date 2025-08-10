package airport.management.system.airportModule.controller;

import airport.management.system.airportModule.request.AirportRequest;
import airport.management.system.airportModule.service.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportServiceImpl airportService;

    @PostMapping("/admin/add-airport")
    public ResponseEntity<?> addNewAirport(@RequestBody AirportRequest airportRequest) {

        return new ResponseEntity<>(airportService.addNewAirport(airportRequest), HttpStatus.CREATED);

    }

    @GetMapping("/public/get-airport/airport-id/{airportId}")
    public ResponseEntity<?> getAirportById(@PathVariable Long airportId) {

        return new ResponseEntity<>(airportService.getAirportById(airportId), HttpStatus.FOUND);

    }

}
