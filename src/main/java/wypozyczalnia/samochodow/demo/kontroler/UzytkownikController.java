package wypozyczalnia.samochodow.demo.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.repozytorium.UzytkownikRepository;

import java.util.List;

@RestController
public class UzytkownikController {

    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @GetMapping("pobierz_uzytkownikow")
    public List<Uzytkownik> pobierzUzytkownikow() {
        return this.uzytkownikRepository.findAll();
    }
}
