package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wypozyczalnia.samochodow.demo.model.Rola;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolaRepository extends JpaRepository<Rola, Long> {

        @Query(value = "select r from  Rola r")
    List<Rola> pobierzKonkretneRole();
}
