package wypozyczalnia.samochodow.demo.kontroler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Samochod;
import wypozyczalnia.samochodow.demo.repozytorium.SamochodRepository;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class SamochodController {


    @Autowired
    private SamochodRepository samochodRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "zapisz_samochod")
    @Transactional
    public Samochod zapiszSamochod(@PathVariable Samochod samochod) {
        log.info("zapis samochodu");

        Samochod s = Samochod.builder()
                .marka(samochod.getMarka())
                .model(samochod.getModel())
                .opis(samochod.getOpis())
                .cenaZaDobe(samochod.getCenaZaDobe())
                .logo(samochod.getLogo())
                .czyWypozyczony(samochod.isCzyWypozyczony())
                .build();
        log.info(s.toString());
        return this.samochodRepository.save(s);
    }

    @GetMapping(value = "pobierz_samochody")
    public List<Samochod> pobierzSamochody() {
        log.info("Trafiles po odczyt samochodow");
        return this.samochodRepository.findAll();
    }
}
