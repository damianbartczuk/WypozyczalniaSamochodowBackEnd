package wypozyczalnia.samochodow.demo.serwisy;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wypozyczalnia.samochodow.demo.model.Rola;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private UzytkownikService uzytkownikService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Uzytkownik user = uzytkownikService.findByUsername(username);
        log.info("username = " + username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rola role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNazwa()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
