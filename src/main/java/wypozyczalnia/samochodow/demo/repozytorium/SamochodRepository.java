package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Samochod;

@Repository
public interface SamochodRepository extends JpaRepository<Samochod, Integer> {
}
