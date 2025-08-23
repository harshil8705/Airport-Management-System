package airport.management.system.staffModule.service;

import airport.management.system.exceptionModule.ApiException;
import airport.management.system.staffModule.model.*;
import airport.management.system.staffModule.repository.StaffRepository;
import airport.management.system.staffModule.repository.StaffRolesRepository;
import airport.management.system.staffModule.repository.StaffStatusRepository;
import airport.management.system.staffModule.request.StaffRequest;
import airport.management.system.staffModule.util.StaffResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StaffStatusRepository staffStatusRepository;

    @Autowired
    private StaffRolesRepository staffRolesRepository;

    @Autowired
    private StaffResponseBuilder staffResponseBuilder;

    @Override
    public Object addNewStaff(StaffRequest staffRequest) {

        Staff staff = Staff.builder()
                .fullName(staffRequest.getFullName())
                .email(staffRequest.getEmail())
                .dateOfBirth(staffRequest.getDateOfBirth())
                .dateOfJoining(LocalDate.now())
                .phoneNumber(staffRequest.getPhoneNumber())
                .assignedAirport(null)
                .assignedFlight(null)
                .build();

        StaffStatusEnum typeEnum = StaffStatusEnum.valueOf(staffRequest.getStaffStatus().toUpperCase());
        StaffStatus staffStatus = staffStatusRepository.findByStaffStatus(typeEnum);

        if (staffStatus != null) {

            staff.setStaffStatus(staffStatus);

        }

        StaffRolesEnum typeEnum1 = StaffRolesEnum.valueOf(staffRequest.getStaffRoles().toUpperCase());
        StaffRoles staffRoles = staffRolesRepository.findByStaffRoles(typeEnum1);

        if (staffRoles != null) {

            staff.setStaffRoles(staffRoles);

        }

        Staff newStaff = staffRepository.save(staff);

        return staffResponseBuilder.buildStaffResponse(newStaff);

    }

    @Override
    public Object getStaffById(Long staffId) {

        Staff existingStaff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ApiException("No staff found by staffId: " + staffId));

        return staffResponseBuilder.buildStaffResponse(existingStaff);

    }

    @Override
    public Object getStaffByName(String name, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Staff> staffPage = staffRepository.findByFullNameContainingIgnoreCase(name, pageDetails);

        List<Staff> staffs = staffPage.getContent();

        if (staffs.isEmpty()) {
            throw new ApiException("No staff found by name: " + name);
        }

        return staffs.stream()
                .map(staff -> staffResponseBuilder.buildStaffResponse(staff))
                .toList();

    }

    @Override
    public Object getStaffByRoles(String staffRole, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        StaffRolesEnum typeEnum = StaffRolesEnum.valueOf(staffRole.toUpperCase());
        StaffRoles staffRoles = staffRolesRepository.findByStaffRoles(typeEnum);

        if (staffRoles == null) {
            throw new ApiException("No staff roles found by staffRole: " + staffRole);
        }

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Staff> staffPage = staffRepository.findByStaffRoles(staffRoles, pageDetails);

        List<Staff> staffList = staffPage.getContent();

        if (staffList.isEmpty()) {
            throw new ApiException("No staff found by staffRole: " + staffRole);
        }

        return staffList.stream()
                .map(staff -> staffResponseBuilder.buildStaffResponse(staff))
                .toList();

    }

    @Override
    public Object getStaffByStatus(String staffStatus, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        StaffStatusEnum typeEnum = StaffStatusEnum.valueOf(staffStatus.toUpperCase());
        StaffStatus status = staffStatusRepository.findByStaffStatus(typeEnum);

        if (status == null) {
            throw new ApiException("No staff found by staffStatus: " + staffStatus);
        }

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Staff> staffPage = staffRepository.findByStaffStatus(status, pageDetails);

        List<Staff> staffs = staffPage.getContent();

        if (staffs.isEmpty()) {
            throw new ApiException("No staff found by staffStatus: " + staffStatus);
        }

        return staffs.stream()
                .map(staff -> staffResponseBuilder.buildStaffResponse(staff))
                .toList();

    }

    @Override
    public Object findAllStaff(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Staff> staffPage = staffRepository.findAll(pageDetails);

        List<Staff> staffs = staffPage.getContent();

        if (staffs.isEmpty()) {
            throw new ApiException("No staff found.");
        }

        return staffs.stream()
                .map(staff -> staffResponseBuilder.buildStaffResponse(staff))
                .toList();

    }

    @Override
    public Object updateStaffById(Long staffId, StaffRequest staffRequest) {

        Staff staffToUpdate = staffRepository.findById(staffId)
                .orElseThrow(() -> new ApiException("No staff by staffId: " + staffId + " doesn't exists"));

        StaffStatusEnum statusEnum = StaffStatusEnum.valueOf(staffRequest.getStaffStatus().toUpperCase());
        StaffStatus staffStatus = staffStatusRepository.findByStaffStatus(statusEnum);
        if (staffStatus == null) {
            throw new ApiException("No staff found by staffStatus: " + staffRequest.getStaffStatus());
        }

        StaffRolesEnum rolesEnum = StaffRolesEnum.valueOf(staffRequest.getStaffRoles().toUpperCase());
        StaffRoles staffRoles = staffRolesRepository.findByStaffRoles(rolesEnum);
        if (staffRoles == null) {
            throw new ApiException("No staff found by staffRoles: " + staffRequest.getStaffRoles());
        }

        staffToUpdate.setEmail(staffRequest.getEmail());
        staffToUpdate.setDateOfBirth(staffRequest.getDateOfBirth());
        staffToUpdate.setFullName(staffRequest.getFullName());
        staffToUpdate.setPhoneNumber(staffRequest.getPhoneNumber());
        staffToUpdate.setStaffStatus(staffStatus);
        staffToUpdate.setStaffRoles(staffRoles);

        return staffResponseBuilder.buildStaffResponse(staffRepository.save(staffToUpdate));

    }

    @Override
    public Object deleteStaffById(Long staffId) {

        Staff staffToDelete = staffRepository.findById(staffId)
                .orElseThrow(() -> new ApiException("No staff found by staffId: " + staffId));

        staffRepository.delete(staffToDelete);

        return "Staff by staffId: " + staffId + " deleted Successfully.";

    }


}
