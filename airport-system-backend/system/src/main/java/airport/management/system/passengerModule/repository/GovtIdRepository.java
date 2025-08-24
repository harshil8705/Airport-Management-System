package airport.management.system.passengerModule.repository;

import airport.management.system.passengerModule.model.GovtId;
import airport.management.system.passengerModule.model.GovtIdEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovtIdRepository extends JpaRepository<GovtId, Long> {

    GovtId findByGovtIdEnum(GovtIdEnum govtIdEnum);

}
