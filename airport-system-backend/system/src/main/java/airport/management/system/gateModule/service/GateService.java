package airport.management.system.gateModule.service;

import airport.management.system.gateModule.request.GateRequest;

import java.util.List;

public interface GateService {

    Object addNewGate(GateRequest gateRequest);

    Object getGateById(Long gateId);

    List<?> getGateByCode(String gateCode, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

}
