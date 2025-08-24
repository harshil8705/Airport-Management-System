package airport.management.system.passengerModule.repository;

import airport.management.system.passengerModule.model.Gender;
import airport.management.system.passengerModule.model.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

    Gender findByGender(GenderEnum genderEnum);

}
