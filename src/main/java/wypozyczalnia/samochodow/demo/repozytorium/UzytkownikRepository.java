package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;

@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {

    @Query(value = "from Uzytkownik u where u.username = :username")
    Uzytkownik findByUsername(String username);
}
