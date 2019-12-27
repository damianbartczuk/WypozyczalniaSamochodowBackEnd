package wypozyczalnia.samochodow.demo.kontroler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Samochod;
import wypozyczalnia.samochodow.demo.serwisy.SamochodService;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class SamochodController {


    @Autowired
    private SamochodService samochodService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "zapisz_samochod")
    @Transactional
    public ResponseEntity<Samochod> zapiszSamochod(@PathVariable Samochod samochod) {
        return new ResponseEntity<>(this.samochodService.zapiszSamochod(samochod), HttpStatus.OK);
    }

    @GetMapping(value = "pobierz_samochody")
    public ResponseEntity<List<Samochod>> pobierzSamochody() {
        log.info("Trafiles po odczyt samochodow");
        return new ResponseEntity<>(this.samochodService.odczytSamochodow(), HttpStatus.OK);
    }
}
