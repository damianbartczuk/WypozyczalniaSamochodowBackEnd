package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import wypozyczalnia.samochodow.demo.model.Rental;

import java.util.List;

@Repository
public interface RentalRepository extends PagingAndSortingRepository<Rental, Integer>, JpaRepository<Rental, Integer> {

    @Query("select r from Rental r where r.idUser = :idUser")
    List<Rental> pobierzWypozyczoneSamochodyZalogowanegoUzytkownika(@PathVariable("idUser") Integer idUser);
}
