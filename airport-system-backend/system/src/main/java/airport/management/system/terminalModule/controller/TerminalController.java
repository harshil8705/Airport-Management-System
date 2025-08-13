package airport.management.system.terminalModule.controller;

import airport.management.system.terminalModule.request.TerminalRequest;
import airport.management.system.terminalModule.service.TerminalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TerminalController {

    @Autowired
    private TerminalServiceImpl terminalService;

    @PostMapping("/admin/add-new-terminal")
    public ResponseEntity<?> addNewTerminal(@RequestBody TerminalRequest terminalRequest) {

        return new ResponseEntity<>(terminalService.addNewTerminal(terminalRequest), HttpStatus.CREATED);

    }

}
