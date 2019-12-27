package wypozyczalnia.samochodow.demo.kontroler;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.serwisy.CarService;

import java.util.List;

@Api(tags = "Car API")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("api/Car")
public class SamochodController {

    private CarService carService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "zapisz_samochod")
    @Transactional
    public ResponseEntity<Car> zapiszSamochod(@PathVariable Car samochod) {
        return new ResponseEntity<>(this.carService.zapiszSamochod(samochod), HttpStatus.OK);
    }

    @GetMapping(value = "pobierz_samochody")
    public ResponseEntity<List<Car>> pobierzSamochody() {
        log.info("Trafiles po odczyt samochodow");
        return new ResponseEntity<>(this.carService.odczytSamochodow(), HttpStatus.OK);
    }
}



