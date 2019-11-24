package wypozyczalnia.samochodow.demo.kontroler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Samochod;
import wypozyczalnia.samochodow.demo.repozytorium.SamochodRepository;

import java.util.List;

@RestController
@Slf4j
public class SamochodController {


    @Autowired
    private SamochodRepository samochodRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("zapis_samochod")
    public void zapiszSamochod(@RequestBody Samochod samochod){
        log.info("zapis samochodu");
        this.samochodRepository.save(samochod);
    }

    @GetMapping("pobierz_samochody")
    public List<Samochod> pobierzSamochody(){
        log.info("Trafiles po odczyt samochodow");
        return this.samochodRepository.findAll();
    }
}
