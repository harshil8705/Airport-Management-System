package airport.management.system.passengerModule.util;

import airport.management.system.passengerModule.model.Gender;
import airport.management.system.passengerModule.model.GenderEnum;
import airport.management.system.passengerModule.repository.GenderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenderDataInitializer {

    @Autowired
    private GenderRepository genderRepository;

    @PostConstruct
    public void insertGenderTypes() {

        if (genderRepository.count() == 0) {

            Gender male = Gender.builder()
                    .genderId(1L)
                    .gender(GenderEnum.MALE)
                    .build();
            genderRepository.save(male);

            Gender female = Gender.builder()
                    .genderId(2L)
                    .gender(GenderEnum.FEMALE)
                    .build();
            genderRepository.save(female);

            Gender other = Gender.builder()
                    .genderId(3L)
                    .gender(GenderEnum.OTHER)
                    .build();
            genderRepository.save(other);

            System.out.println("Gender Types Initialized.");

        } else {
            System.out.println("Gender Types already exists. Skipping Initialization.");
        }

    }

}
