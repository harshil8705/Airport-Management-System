package airport.management.system.passengerModule.repository;

import airport.management.system.passengerModule.model.Gender;
import airport.management.system.passengerModule.model.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Page<Passenger> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageDetails);

    Optional<Passenger> findByEmail(String email);

    Optional<Passenger> findByPhoneNumber(String phoneNumber);

    Optional<Passenger> findByPassportNumber(String passportNumber);

    Page<Passenger> findByGender(Gender gender1, Pageable pageDetails);

}
