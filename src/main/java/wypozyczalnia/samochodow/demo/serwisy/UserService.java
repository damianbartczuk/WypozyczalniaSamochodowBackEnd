package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.repozytorium.UserRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> odczytUzytkownikow(){
        log.info("Odczytujemy uzytkownikow w serwisie posortowanych po nazwie uzytkownikow");
        return this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
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
        log.info("zahaszowane hasło: {}" + uzytkownik.getPassword());
        return this.userRepository.save(uzytkownik);
    }

    public User findByUsername(String username) {
        if(Strings.isEmpty(username)) {
            throw new UsernameNotFoundException("Uzytkownik o takiej nazwie nie istnieje");
        }
        return this.userRepository.findByUsername(username);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
