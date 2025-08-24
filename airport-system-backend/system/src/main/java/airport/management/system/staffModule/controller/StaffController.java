package airport.management.system.staffModule.controller;

import airport.management.system.configuration.AppConstants;
import airport.management.system.staffModule.request.StaffRequest;
import airport.management.system.staffModule.service.StaffServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    private StaffServiceImpl staffService;

    @PostMapping("/admin/add-new-staff")
    public ResponseEntity<?> addNewStaff(@RequestBody StaffRequest staffRequest) {

        return new ResponseEntity<>(staffService.addNewStaff(staffRequest), HttpStatus.CREATED);

    }

    @GetMapping("/public/staff/staff-id/{staffId}")
    public ResponseEntity<?> getStaffById(@PathVariable Long staffId) {

        return new ResponseEntity<>(staffService.getStaffById(staffId), HttpStatus.FOUND);

    }

    @GetMapping("/public/staff/staff-name/{name}")
    public ResponseEntity<?> getStaffByName(
            @PathVariable String name,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_STAFF_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(staffService.getStaffByName(name, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/staff/staff-roles/{staffRole}")
    public ResponseEntity<?> getStaffByRoles(
            @PathVariable String staffRole,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_STAFF_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(staffService.getStaffByRoles(staffRole, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/staff/staff-status/{staffStatus}")
    public ResponseEntity<?> getStaffByStatus(
            @PathVariable String staffStatus,
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_STAFF_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(staffService.getStaffByStatus(staffStatus, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @GetMapping("/public/staff")
    public ResponseEntity<?> getAllStaff(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_STAFF_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder
    ) {

        return new ResponseEntity<>(staffService.findAllStaff(pageNumber, pageSize, sortBy, sortOrder), HttpStatus.FOUND);

    }

    @PutMapping("/admin/update-staff/staff-id/{staffId}")
    public ResponseEntity<?> updateStaffById(@PathVariable Long staffId, @RequestBody StaffRequest staffRequest) {

        return new ResponseEntity<>(staffService.updateStaffById(staffId, staffRequest), HttpStatus.FOUND);

    }

    @DeleteMapping("/admin/delete-staff/staff-id/{staffId}")
    public ResponseEntity<?> deleteStaffById(@PathVariable Long staffId) {

        return new ResponseEntity<>(staffService.deleteStaffById(staffId), HttpStatus.OK);

    }

    @GetMapping("/admin/get-staff-details/staff-id/{staffId}")
    public ResponseEntity<?> getCompleteStaffDetailsById(@PathVariable Long staffId) {

        return new ResponseEntity<>(staffService.getCompleteStaffDetailsById(staffId), HttpStatus.FOUND);

    }

    @PutMapping("/admin/assign-airport/airport-id/{airportId}/staff-id/{staffId}")
    public ResponseEntity<?> assignAirportToStaff(@PathVariable Long airportId, @PathVariable Long staffId) {

        return new ResponseEntity<>(staffService.assignAirportToStaff(airportId, staffId), HttpStatus.OK);

    }

}
