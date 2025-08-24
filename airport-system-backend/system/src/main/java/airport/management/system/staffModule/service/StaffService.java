package airport.management.system.staffModule.service;

import airport.management.system.staffModule.request.StaffRequest;

public interface StaffService {

    Object addNewStaff(StaffRequest staffRequest);

    Object getStaffById(Long staffId);

    Object getStaffByName(String name, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object getStaffByRoles(String staffRole, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object getStaffByStatus(String staffStatus, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object findAllStaff(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object updateStaffById(Long staffId, StaffRequest staffRequest);

    Object deleteStaffById(Long staffId);

    Object getCompleteStaffDetailsById(Long staffId);

    Object assignAirportToStaff(Long airportId, Long staffId);

}
