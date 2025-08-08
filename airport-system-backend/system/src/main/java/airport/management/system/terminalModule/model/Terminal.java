package airport.management.system.terminalModule.model;

import airport.management.system.airportModule.model.Airport;
import airport.management.system.flightModule.model.Flight;
import airport.management.system.gateModule.model.Gate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @NotNull
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "terminal_type_fk_id")
    private TerminalType terminalType;

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

    @NotNull
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "airport_fk_id")
    private Airport airport;

}
