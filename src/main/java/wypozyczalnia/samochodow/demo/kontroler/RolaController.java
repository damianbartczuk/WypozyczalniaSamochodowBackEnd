package wypozyczalnia.samochodow.demo.kontroler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Rola;
import wypozyczalnia.samochodow.demo.repozytorium.RolaRepository;

import java.util.List;

@RestController
@Slf4j
public class RolaController {

    @Autowired
    private RolaRepository rolaRepository;

    @GetMapping(value = "pobierz_role")
    public List<Rola> pobierzWszystkieRole() {
        return this.rolaRepository.findAll();
    }

    @GetMapping("pobierz_konkretne_role")
    public List<Rola> pobierzKonkretneRole(){
        return this.rolaRepository.pobierzKonkretneRole();
    }
}
