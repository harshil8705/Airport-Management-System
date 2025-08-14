package airport.management.system.terminalModule.service;

import airport.management.system.terminalModule.request.TerminalRequest;

import java.util.List;
import java.util.Set;

public interface TerminalService {

    Object addNewTerminal(TerminalRequest terminalRequest);

    Object getTerminalById(Long terminalId);

    List<?> getTerminalByCode(String terminalCode, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<?> getAllTerminals(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Object updateTerminalById(Long terminalId, TerminalRequest terminalRequest);

    Object deleteTerminalById(Long terminalId);

    Object getCompleteTerminalDetails(Long terminalId);

    Object removeTypeOfTerminalById(Long terminalId, Set<String> terminalTypes);

    Object assignAirportToTerminalById(Long airportId, Long terminalId);

}
