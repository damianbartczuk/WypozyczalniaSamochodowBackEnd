package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
