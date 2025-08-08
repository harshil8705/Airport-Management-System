package airport.management.system.airportModule.model;

import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.terminalModule.model.Terminal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;

    @NotBlank
    @Column(unique = true)
    private String airportName;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sourceAirport", cascade = CascadeType.ALL)
    private List<Flight> outgoingFlight;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL)
    private List<Flight> incomingFlight;

    @OneToMany(mappedBy = "assignedAirport", cascade = CascadeType.ALL)
    private List<Staff> staff;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Gate> gates;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Terminal> terminals;

}
