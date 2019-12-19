package wypozyczalnia.samochodow.demo.kontroler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.repozytorium.UzytkownikRepository;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class UzytkownikController {

    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @GetMapping("pobierz_uzytkownikow")
    public List<Uzytkownik> pobierzUzytkownikow() {
        return this.uzytkownikRepository.findAll();
    }

    @PostMapping("zapisz_uzytkownika")
    public Uzytkownik zapiszUzytkownika(@RequestBody Uzytkownik uzytkownik) {
        log.info("Trafiles pod zapis uzytkownika {}", uzytkownik);
        return this.uzytkownikRepository.save(uzytkownik);
    }
}
