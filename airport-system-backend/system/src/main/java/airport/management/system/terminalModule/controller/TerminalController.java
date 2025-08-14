package airport.management.system.terminalModule.controller;

import airport.management.system.configuration.AppConstants;
import airport.management.system.terminalModule.request.TerminalRequest;
import airport.management.system.terminalModule.service.TerminalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class TerminalController {

    @Autowired
    private TerminalServiceImpl terminalService;

    @PostMapping("/admin/add-new-terminal")
    public ResponseEntity<?> addNewTerminal(@RequestBody TerminalRequest terminalRequest) {

        return new ResponseEntity<>(terminalService.addNewTerminal(terminalRequest), HttpStatus.CREATED);

    }

    @GetMapping("/public/terminals/terminal-id/{terminalId}")
    public ResponseEntity<?> getTerminalById(@PathVariable Long terminalId) {

        return new ResponseEntity<>(terminalService.getTerminalById(terminalId), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-terminal/terminal-code/{terminalCode}")
    public ResponseEntity<List<?>> getTerminalByCode(
            @PathVariable String terminalCode,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TERMINAL_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(terminalService.getTerminalByCode(terminalCode, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-terminal/all")
    public ResponseEntity<List<?>> getAllTerminals(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TERMINAL_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(terminalService.getAllTerminals(pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @PutMapping("/admin/update-terminal/terminal-id/{terminalId}")
    public ResponseEntity<?> updateTerminalById(
            @PathVariable Long terminalId,
            @RequestBody TerminalRequest terminalRequest) {

        return new ResponseEntity<>(terminalService.updateTerminalById(terminalId, terminalRequest), HttpStatus.OK);

    }

    @DeleteMapping("/admin/delete-terminal/terminal-id/{terminalId}")
    public ResponseEntity<?> deleteTerminalById(@PathVariable Long terminalId) {

        return new ResponseEntity<>(terminalService.deleteTerminalById(terminalId), HttpStatus.OK);

    }

    @GetMapping("/admin/get-terminal-details/terminal-id/{terminalId}")
    public ResponseEntity<?> getCompleteTerminalDetails(@PathVariable Long terminalId) {

        return new ResponseEntity<>(terminalService.getCompleteTerminalDetails(terminalId), HttpStatus.FOUND);

    }

    @PutMapping("/admin/remove-terminal-types/terminal-id/{terminalId}")
    public ResponseEntity<?> removeTypeOfTerminalById(
            @PathVariable Long terminalId,
            @RequestParam(name = "terminalTypes") Set<String> terminalTypes) {

        return new ResponseEntity<>(terminalService.removeTypeOfTerminalById(terminalId, terminalTypes), HttpStatus.OK);

    }

    @PutMapping("/admin/assign-airport-terminal/airport-id/{airportId}/terminal-id/{terminalId}")
    public ResponseEntity<?> assignAirportToTerminalById(@PathVariable Long airportId, @PathVariable Long terminalId) {

        return new ResponseEntity<>(terminalService.assignAirportToTerminalById(airportId, terminalId), HttpStatus.OK);

    }

}
