package airport.management.system.gateModule.service;

import airport.management.system.exceptionModule.ApiException;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.gateModule.model.GateStatus;
import airport.management.system.gateModule.model.GateStatusEnum;
import airport.management.system.gateModule.repository.GateRepository;
import airport.management.system.gateModule.repository.GateStatusRepository;
import airport.management.system.gateModule.request.GateRequest;
import airport.management.system.gateModule.util.GateResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GateServiceImpl implements GateService{

    @Autowired
    private GateRepository gateRepository;

    @Autowired
    private GateStatusRepository gateStatusRepository;

    @Autowired
    private GateResponseBuilder responseBuilder;

    @Override
    public Object addNewGate(GateRequest gateRequest) {

        Gate gate = Gate.builder()
                .gateCode(gateRequest.getGateCode())
                .closeTime(gateRequest.getCloseTime())
                .openTime(gateRequest.getOpenTime())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .flight(null)
                .airport(null)
                .terminal(null)
                .gateStatus(null)
                .build();
        GateStatusEnum typeEnum = GateStatusEnum.valueOf(gateRequest.getGateStatus().toUpperCase());
        GateStatus gateStatus = gateStatusRepository.findByGateStatus(typeEnum);
        if (gateStatus != null) {

            gate.setGateStatus(gateStatus);

        }

        Gate newGate = gateRepository.save(gate);

        return responseBuilder.buildGateResponse(newGate);

    }

    @Override
    public Object getGateById(Long gateId) {

        Gate existingGate = gateRepository.findById(gateId)
                .orElseThrow(() -> new ApiException("No gate found by gateId: " + gateId));

        return responseBuilder.buildGateResponse(existingGate);

    }

    @Override
    public List<?> getGateByCode(String gateCode, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Gate> gatePage = gateRepository.findByGateCodeContainingIgnoreCase(gateCode, pageDetails);

        List<Gate> gates = gatePage.getContent();
        if (gates.isEmpty()) {

            throw new ApiException("No gate found by gateCode: " + gateCode);

        }

        return gates.stream()
                .map(gate -> responseBuilder.buildGateResponse(gate))
                .toList();

    }

}
