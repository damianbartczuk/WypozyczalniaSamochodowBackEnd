package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Rola;

@Repository
public interface UzytkownikRepository extends JpaRepository<Rola, Integer> {
}
