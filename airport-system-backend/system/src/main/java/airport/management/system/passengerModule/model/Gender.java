package airport.management.system.passengerModule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gender {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

}
