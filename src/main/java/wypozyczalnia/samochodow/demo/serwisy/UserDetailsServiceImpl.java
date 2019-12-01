package wypozyczalnia.samochodow.demo.serwisy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Rola;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.repozytorium.UzytkownikRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Uzytkownik uzytkownik = uzytkownikRepository.findByUsername("dbartczuk");
        if(uzytkownik == null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rola r: uzytkownik.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getNazwa()));
        }
        return new User(uzytkownik.getUsername(), uzytkownik.getPassword(), grantedAuthorities);
    }
}
