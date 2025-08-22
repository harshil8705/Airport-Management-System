package airport.management.system.staffModule.controller;

import airport.management.system.staffModule.request.StaffRequest;
import airport.management.system.staffModule.service.StaffServiceImpl;
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

}
