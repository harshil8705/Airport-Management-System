package airport.management.system.terminalModule.service;

import airport.management.system.airportModule.response.AirportResponse;
import airport.management.system.airportModule.utils.BuildAirportResponse;
import airport.management.system.exceptionModule.ApiException;
import airport.management.system.terminalModule.model.Terminal;
import airport.management.system.terminalModule.model.TerminalTypeEnum;
import airport.management.system.terminalModule.repository.TerminalRepository;
import airport.management.system.terminalModule.repository.TerminalTypeRepository;
import airport.management.system.terminalModule.request.TerminalRequest;
import airport.management.system.terminalModule.response.TerminalResponse2;
import airport.management.system.terminalModule.util.BuildTerminalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private TerminalTypeRepository terminalTypeRepository;

    @Autowired
    private BuildTerminalResponse terminalResponse;

    @Autowired
    private BuildAirportResponse buildResponse;

    @Override
    public Object addNewTerminal(TerminalRequest terminalRequest) {

        Terminal terminal = Terminal.builder()
                .terminalCode(terminalRequest.getTerminalCode())
                .location(terminalRequest.getLocation())
                .isActive(terminalRequest.getIsActive())
                .totalGates(terminalRequest.getTotalGates())
                .gates(null)
                .airport(null)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .flights(null)
                .build();

        Terminal newTerminal = terminalRepository.save(terminal);

        for(String str : terminalRequest.getTerminalTypes()) {

            try {

                TerminalTypeEnum typeEnum = TerminalTypeEnum.valueOf(str.toUpperCase());
                terminalTypeRepository.findByTerminalType(typeEnum)
                        .ifPresent(newTerminal.getTerminalTypes()::add);

            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

        }

        Terminal updatedTerminal = terminalRepository.save(newTerminal);

        return terminalResponse.buildTerminalResponse(updatedTerminal);

    }

    @Override
    public Object getTerminalById(Long terminalId) {

        Terminal existingTerminal = terminalRepository.findById(terminalId)
                .orElseThrow(() -> new ApiException("No Terminal found by terminalId: " + terminalId));

        return terminalResponse.buildTerminalResponse(existingTerminal);

    }

    @Override
    public List<?> getTerminalByCode(String terminalCode, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<Terminal> terminalPage = terminalRepository.findByTerminalCodeContainingIgnoreCase(terminalCode, pageRequest);
        List<Terminal> terminals = terminalPage.getContent();

        if (terminals.isEmpty()) {
            throw new ApiException("No terminals found by terminalCode: " + terminalCode);
        }

        return terminals.stream()
                .map(terminal -> terminalResponse.buildTerminalResponse(terminal))
                .toList();
    }

    @Override
    public List<?> getAllTerminals(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<Terminal> terminalPage = terminalRepository.findAll(pageRequest);

        List<Terminal> terminals = terminalPage.getContent();

        if (terminals.isEmpty()) {
            throw new ApiException("No terminals found.");
        }

        return terminals.stream()
                .map(terminal -> terminalResponse.buildTerminalResponse(terminal))
                .toList();
    }

    @Override
    public Object updateTerminalById(Long terminalId, TerminalRequest terminalRequest) {

        Terminal existingTerminal = terminalRepository.findById(terminalId)
                .orElseThrow(() -> new ApiException("No terminal found bu terminalId: " + terminalId));

        existingTerminal.setTerminalCode(terminalRequest.getTerminalCode());
        existingTerminal.setUpdatedAt(LocalDateTime.now());
        existingTerminal.setIsActive(terminalRequest.getIsActive());
        existingTerminal.setLocation(terminalRequest.getLocation());
        existingTerminal.setTotalGates(terminalRequest.getTotalGates());

        Terminal updatedTerminal = terminalRepository.save(existingTerminal);

        for (String str : terminalRequest.getTerminalTypes()) {

            try{

                TerminalTypeEnum typeEnum = TerminalTypeEnum.valueOf(str.toUpperCase());
                terminalTypeRepository.findByTerminalType(typeEnum)
                        .ifPresent(updatedTerminal.getTerminalTypes()::add);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        Terminal newlyUpdatedTerminal = terminalRepository.save(updatedTerminal);

        return terminalResponse.buildTerminalResponse(newlyUpdatedTerminal);

    }

    @Override
    public Object deleteTerminalById(Long terminalId) {

        Terminal terminalToDelete = terminalRepository.findById(terminalId)
                .orElseThrow(() -> new ApiException("No terminal found by terminalId: " + terminalId));

        terminalRepository.delete(terminalToDelete);

        return "Terminal with terminalId: " + terminalId + " deleted Successfully.";
    }

    @Override
    public Object getCompleteTerminalDetails(Long terminalId) {

        Terminal existingTerminal = terminalRepository.findById(terminalId)
                .orElseThrow(() -> new ApiException("No terminal found by terminalId: " + terminalId));

        return TerminalResponse2.builder()
                .terminalId(existingTerminal.getTerminalId())
                .terminalCode(existingTerminal.getTerminalCode())
                .terminalTypes(existingTerminal.getTerminalTypes().isEmpty() ? null : existingTerminal.getTerminalTypes())
                .airport(existingTerminal.getAirport() == null ? null : buildResponse.buildAirportResponse(existingTerminal.getAirport()))
                .createdAt(existingTerminal.getCreatedAt())
                .flights(existingTerminal.getFlights().isEmpty() ? null : existingTerminal.getFlights())
                .gates(existingTerminal.getGates().isEmpty() ? null : existingTerminal.getGates())
                .isActive(existingTerminal.getIsActive())
                .location(existingTerminal.getLocation())
                .totalGates(existingTerminal.getTotalGates())
                .updatedAt(existingTerminal.getUpdatedAt())
                .build();
    }

    @Override
    public Object removeTypeOfTerminalById(Long terminalId, Set<String> terminalTypes) {

        Terminal existingTerminal = terminalRepository.findById(terminalId)
                .orElseThrow(() -> new ApiException("No terminal found by terminalId: " + terminalId));

        for (String str : terminalTypes) {

            try {

                TerminalTypeEnum typeEnum = TerminalTypeEnum.valueOf(str.toUpperCase());
                terminalTypeRepository.findByTerminalType(typeEnum)
                        .ifPresent(existingTerminal.getTerminalTypes()::remove);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        Terminal updatedTerminal = terminalRepository.save(existingTerminal);

        return terminalResponse.buildTerminalResponse(updatedTerminal);
    }

}
