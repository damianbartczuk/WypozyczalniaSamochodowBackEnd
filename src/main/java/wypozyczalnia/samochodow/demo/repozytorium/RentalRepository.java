package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Rental;

@Repository
public interface RentalRepository extends PagingAndSortingRepository<Rental, Integer> {
}
