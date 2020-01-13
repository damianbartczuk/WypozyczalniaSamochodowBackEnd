package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.repozytorium.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public Page<User> odczytUzytkownikow(Pageable pageable){
        log.info("Odczytujemy uzytkownikow w serwisie posortowanych po nazwie uzytkownikow");
        return this.userRepository.findAll(pageable);
    }

    public User pobierzUzytkownika(String username, String password) {
        log.info("Odeczytujemy uzytkownika z username = {} oraz password = {}", username, password);
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

    public User pobierzUzytkownika(String username) {
        log.info("Odeczytujemy uzytkownika z username = {}", username);
        return this.userRepository.findByUsername(username);
    }

    public User zapiszUzytkownika(User uzytkownik) {
        log.info("Trafiles pod zapis uzytkownika {}", uzytkownik);
        uzytkownik.setPassword(bCryptPasswordEncoder().encode(uzytkownik.getPassword()));
        log.info("zahaszowane hasło: {}", uzytkownik.getPassword());
        return this.userRepository.save(uzytkownik);
    }

    public User findByUsername(String username) {
        if(Strings.isEmpty(username)) {
            throw new UsernameNotFoundException("Uzytkownik o takiej nazwie nie istnieje");
        }
        return this.userRepository.findByUsername(username);
    }

    public String findPasswordForUser(String username){
        return this.userRepository.findByUsername(username).getPassword();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
