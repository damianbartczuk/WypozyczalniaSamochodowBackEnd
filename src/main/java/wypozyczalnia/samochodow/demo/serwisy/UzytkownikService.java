package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
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
        return this.uzytkownikRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }
    public Uzytkownik zapiszUzytkownika(Uzytkownik uzytkownik) {
        log.info("Trafiles pod zapis uzytkownika {}", uzytkownik);
        uzytkownik.setPassword(bCryptPasswordEncoder().encode(uzytkownik.getPassword()));
        log.info("zahaszowane hasło: {}" + uzytkownik.getPassword());
        return this.uzytkownikRepository.save(uzytkownik);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
