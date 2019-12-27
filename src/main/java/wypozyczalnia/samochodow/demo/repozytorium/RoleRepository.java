package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
