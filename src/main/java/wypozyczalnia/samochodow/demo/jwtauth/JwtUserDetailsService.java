package wypozyczalnia.samochodow.demo.jwtauth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String username) {
//        TODO tu trzeba załadować role
//        wypozyczalnia.samochodow.demo.model.User pobranyUzytkownik = entityManager.createQuery("select u from User u where u.username = :username", wypozyczalnia.samochodow.demo.model.User.class).setParameter("username", username).getSingleResult();
//        if (pobranyUzytkownik != null) {
//            Set<Role> roles = pobranyUzytkownik.getRoles();
//            List<Role> r = roles.stream().collect(Collectors.toList());
//            List<MyGrantedAuthority> rolesAsStrings = new ArrayList<>();
//            for (Role x : r) {
//                rolesAsStrings.add(new MyGrantedAuthority(x));
//            }
        String haslo = this.entityManager.createQuery("select u.password from User u where u.username = :username", String.class).setParameter("username", username).getSingleResult();
            return new User(username, haslo, new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
    }
}
