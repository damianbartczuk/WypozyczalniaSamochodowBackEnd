package wypozyczalnia.samochodow.demo.repozytorium;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wypozyczalnia.samochodow.demo.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query(value = "from User u where u.username = :username and u.password = :password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query(value = "from User u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
