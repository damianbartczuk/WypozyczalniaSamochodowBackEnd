package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.repozytorium.CarRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    public List<Car> odczytSamochodow(){
        log.info("Odczytujemy samochody w serwisie posortowanych po marce");
        return this.carRepository.findAll(Sort.by(Sort.Direction.ASC, "marka"));
    }
    public Car zapiszSamochod(Car samochod) {
        log.info("Trafiles pod zapis samochodu {}", samochod);
        return this.carRepository.save(samochod);
    }
}
