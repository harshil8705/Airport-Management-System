package airport.management.system.airportModule.controller;

import airport.management.system.configuration.AppConstants;
import airport.management.system.airportModule.request.AirportRequest;
import airport.management.system.airportModule.service.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/public/get-airport/airport-name/{airportName}")
    public ResponseEntity<List<?>> getAirportByName(
            @PathVariable String airportName,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_AIRPORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(airportService.getAirportByName(airportName, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-airport/airport-city/{city}")
    public ResponseEntity<List<?>> getAirportByCity(
            @PathVariable String city,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_AIRPORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(airportService.getAirportByCity(city, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-airport/airport-country/{country}")
    public ResponseEntity<List<?>> getAirportByCountry(
            @PathVariable String country,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_AIRPORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(airportService.getAirportByCountry(country, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-airport/all")
    public ResponseEntity<List<?>> getAllAirports(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_AIRPORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(airportService.getAllAirports(pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @PutMapping("/admin/update-airport/airport-id/{airportId}")
    public ResponseEntity<?> updateAirportById(
            @PathVariable Long airportId,
            @RequestBody AirportRequest airportRequest) {

        return new ResponseEntity<>(airportService.updateAirportById(airportId, airportRequest), HttpStatus.OK);

    }

    @DeleteMapping("/admin/delete-airport/airport-id/{airportId}")
    public ResponseEntity<?> deleteAirportById(@PathVariable Long airportId) {

        return new ResponseEntity<>(airportService.deleteAirportById(airportId), HttpStatus.OK);

    }

    @GetMapping("/admin/get-airport-details/airport-id/{airportId}")
    public ResponseEntity<?> getCompleteAirportDetails(@PathVariable Long airportId) {

        return new ResponseEntity<>(airportService.getCompleteAirportDetails(airportId), HttpStatus.FOUND);

    }

    @PutMapping("/admin/remove-airport-types/airport-id/{airportId}")
    public ResponseEntity<?> removeTypeOfAirportById(
            @PathVariable Long airportId,
            @RequestParam(name = "airportTypes") Set<String> airportTypes) {

        return new ResponseEntity<>(airportService.removeTypeOfAirportById(airportId, airportTypes), HttpStatus.OK);

    }

}
