package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "from User u where u.username = :username")
    User findByUsername(String username);
}
