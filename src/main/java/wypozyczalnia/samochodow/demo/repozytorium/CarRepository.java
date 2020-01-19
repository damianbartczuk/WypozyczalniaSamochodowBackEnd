package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Car;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Integer>, JpaRepository<Car, Integer> {
}
