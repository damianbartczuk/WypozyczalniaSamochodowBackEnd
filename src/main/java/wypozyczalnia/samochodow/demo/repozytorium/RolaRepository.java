package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import wypozyczalnia.samochodow.demo.model.Rola;
import org.springframework.stereotype.Repository;

@Repository
public interface RolaRepository extends JpaRepository<Rola, Integer> {
}
