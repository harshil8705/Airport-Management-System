package airport.management.system.airportModule.model;

import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import airport.management.system.staffModule.model.Staff;
import airport.management.system.terminalModule.model.Terminal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @NotNull
    private Integer totalTerminals;

    @NotNull
    private Integer totalGates;

    @NotNull
    private Integer totalStaff;

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "airport_airport_type",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_types_fk_id")
    )
    private Set<AirportType> airportTypes = new HashSet<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sourceAirport", cascade = CascadeType.ALL)
    private List<Flight> outgoingFlight = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL)
    private List<Flight> incomingFlight = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "assignedAirport", cascade = CascadeType.ALL)
    private List<Staff> staff = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Gate> gates = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Terminal> terminals = new ArrayList<>();

}
