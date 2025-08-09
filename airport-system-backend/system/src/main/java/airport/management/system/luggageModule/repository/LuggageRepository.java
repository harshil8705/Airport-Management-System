package airport.management.system.luggageModule.repository;

import airport.management.system.luggageModule.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuggageRepository extends JpaRepository<Long, Luggage> {
}
