package airport.management.system.staffModule.service;

import airport.management.system.staffModule.request.StaffRequest;

public interface StaffService {

    Object addNewStaff(StaffRequest staffRequest);

    Object getStaffById(Long staffId);

}
