package airport.management.system.terminalModule.model;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terminalId;

    @NotBlank
    private String terminalCode;

    @NotBlank
    private String location;

    @NotNull
    private Integer totalGates;

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "terminal_terminal_type",
            joinColumns = @JoinColumn(name = "terminal_id"),
            inverseJoinColumns = @JoinColumn(name = "terminal_types_fk_id")
    )
    private Set<TerminalType> terminalTypes = new HashSet<>();

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private Boolean isActive;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "terminal", cascade = CascadeType.ALL)
    private List<Gate> gates;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "terminal", cascade = CascadeType.ALL)
    private List<Flight> flights;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "airport_fk_id")
    private Airport airport;

}
