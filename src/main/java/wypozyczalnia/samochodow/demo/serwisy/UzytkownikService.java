package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.repozytorium.UzytkownikRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UzytkownikService {

    private UzytkownikRepository uzytkownikRepository;

    public List<Uzytkownik> odczytUzytkownikow(){
        log.info("Odczytujemy uzytkownikow w serwisie posortowanych po nazwie uzytkownikow");
        return this.uzytkownikRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }

    public Uzytkownik pobierzUzytkownika(String username, String password) {
        log.info("Odeczytujemy uzytkownika z username = {} oraz password = {}", username, password);
        return this.uzytkownikRepository.findByUsernameAndPassword(username, password);
    }

    public Uzytkownik pobierzUzytkownika(String username) {
        log.info("Odeczytujemy uzytkownika z username = {}", username);
        return this.uzytkownikRepository.findByUsername(username);
    }

    public Uzytkownik zapiszUzytkownika(Uzytkownik uzytkownik) {
        log.info("Trafiles pod zapis uzytkownika {}", uzytkownik);
        uzytkownik.setPassword(bCryptPasswordEncoder().encode(uzytkownik.getPassword()));
        log.info("zahaszowane hasło: {}" + uzytkownik.getPassword());
        return this.uzytkownikRepository.save(uzytkownik);
    }

    public Uzytkownik findByUsername(String username) {
        if(Strings.isEmpty(username)) {
            throw new UsernameNotFoundException("Uzytkownii o takiej nazwie nie istnieje");
        }
        return this.uzytkownikRepository.findByUsername(username);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
