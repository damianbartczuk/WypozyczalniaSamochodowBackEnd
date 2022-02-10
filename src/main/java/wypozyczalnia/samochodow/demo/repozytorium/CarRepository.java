package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Integer>, JpaRepository<Car, Integer> {

    @Query(value = "select c from Car c where c.czyWypozyczony = false")
    Page<Car> pobierzWolneAuta(Pageable pageable);
}
