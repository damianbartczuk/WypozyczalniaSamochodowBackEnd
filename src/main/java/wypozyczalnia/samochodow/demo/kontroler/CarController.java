package wypozyczalnia.samochodow.demo.kontroler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.repozytorium.CarRepository;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {


    @Autowired
    private CarRepository carRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping(value = "zapisz_samochod")
    @Transactional
    public Car zapiszSamochod(@RequestBody Car car) {
        log.info("zapis samochodu");

        Car s = Car.builder()
                .marka(car.getMarka())
                .model(car.getModel())
                .opis(car.getOpis())
                .cenaZaDobe(car.getCenaZaDobe())
                .logo(car.getLogo())
                .czyWypozyczony(car.isCzyWypozyczony())
                .build();
        log.info(s.toString());
        return this.carRepository.save(s);
    }

    @GetMapping( value = "pobierz_samochody")
    public List<Car> pobierzSamochody() {
        log.info("Trafiles po odczyt samochodow");
        return this.carRepository.findAll();
    }
}
