package wypozyczalnia.samochodow.demo.kontroler;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.serwisy.CarService;

import java.util.List;

@Api(tags = "Car API")
@RestController
@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = {"Authorization", "Access-Control-Allow-Origin", "Content-type", "Access-Control-Expose-Headers"})
@AllArgsConstructor
public class CarController {
    private static final Logger log = LoggerFactory.getLogger(CarController.class);
    private CarService carService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "zapisz_samochod")
    @Transactional
    public ResponseEntity<Car> zapiszSamochod(@PathVariable Car samochod) {
        log.info("zapis samochodu");
        return new ResponseEntity<>(this.carService.zapiszSamochod(samochod), HttpStatus.OK);
    }

    @GetMapping(value = "pobierz_samochody")
    @ApiOperation("Metoda zwraca liste samochodow które spełniają krytaria podane w parametrach")
    public ResponseEntity<List<Car>> pobierzSamochody(@RequestParam @Nullable Integer pageNumber, @RequestParam @Nullable Integer pageSize) {
        log.info("Trafiles po odczyt samochodow pageNumber = {} i pageSize = {}", pageNumber, pageSize);
        return new ResponseEntity<>(this.carService.odczytSamochodow( pageNumber, pageSize), HttpStatus.OK);
    }
}



