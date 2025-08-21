package airport.management.system.gateModule.controller;

import airport.management.system.configuration.AppConstants;
import airport.management.system.gateModule.request.GateRequest;
import airport.management.system.gateModule.service.GateServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GateController {

    @Autowired
    private GateServiceImpl gateService;

    @PostMapping("/admin/add-gate")
    public ResponseEntity<?> addNewGate(@RequestBody GateRequest gateRequest) {

        return new ResponseEntity<>(gateService.addNewGate(gateRequest), HttpStatus.CREATED);

    }

    @GetMapping("/public/gates/gate-id/{gateId}")
    public ResponseEntity<?> getGateById(@PathVariable Long gateId) {

        return new ResponseEntity<>(gateService.getGateById(gateId), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-gate/gate-code/{gateCode}")
    public ResponseEntity<List<?>> getGateByCode(
            @PathVariable String gateCode,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_GATE_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(gateService.getGateByCode(gateCode, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-gate/gate-status/{gateStatus}")
    public ResponseEntity<List<?>> getGateByStatus(
            @PathVariable String gateStatus,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_GATE_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder
    ) {

        return new ResponseEntity<>(gateService.getGateByStatus(gateStatus, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/get-all-gates")
    public ResponseEntity<List<?>> getAllGates() {

        return new ResponseEntity<>(gateService.getAllGates(), HttpStatus.FOUND);

    }

    @PutMapping("/admin/update-gate/gate-id/{gateId}")
    public ResponseEntity<?> updateGateById(@PathVariable Long gateId, @RequestBody GateRequest gateRequest) {

        return new ResponseEntity<>(gateService.updateGateById(gateId, gateRequest), HttpStatus.OK);

    }

    @DeleteMapping("/admin/delete-gate/gate-id/{gateId}")
    public ResponseEntity<?> deleteGateById(@PathVariable Long gateId) {

        return new ResponseEntity<>(gateService.deleteGateById(gateId), HttpStatus.OK);

    }

    @GetMapping("/admin/get-gate-details/gate-id/{gateId}")
    public ResponseEntity<?> getCompleteGateDetails(@PathVariable Long gateId) {

        return new ResponseEntity<>(gateService.getCompleteGateDetails(gateId), HttpStatus.FOUND);

    }

    @PutMapping("/admin/update-gate-status/gate-id/{gateId}")
    public ResponseEntity<?> updateGateStatusById(
            @PathVariable Long gateId,
            @RequestParam(name = "gateStatus", defaultValue = "available", required = false) String gateStatus) {

        return new ResponseEntity<>(gateService.updateGateStatusById(gateId, gateStatus), HttpStatus.OK);

    }

    @PutMapping("/admin/assign-terminal-gate/terminal-id/{terminalId}/gate-id/{gateId}")
    public ResponseEntity<?> assignTerminalToGate(@PathVariable Long terminalId, @PathVariable Long gateId) {

        return new ResponseEntity<>(gateService.assignTerminalToGate(terminalId, gateId), HttpStatus.OK);

    }

}
