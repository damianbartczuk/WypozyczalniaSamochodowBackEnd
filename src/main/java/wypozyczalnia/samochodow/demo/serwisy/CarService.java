package wypozyczalnia.samochodow.demo.serwisy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.repozytorium.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    private CarRepository carRepository;

    @Autowired()
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Value("${rozmiar.pojedynczej.strony}")
    private Integer defaultPageSize;

    public List<Car> odczytSamochodow(Integer pageNumber, Integer pageSize){
        log.info("Odczytujemy samochody w serwisie");
        if(pageSize == null && pageNumber == null) {
            return this.carRepository.pobierzWolneAuta(PageRequest.of(0, 2)).getContent();
        }
        if(pageSize == null){
            log.info("Uzywam domyslnegio rozmiaryu strony {} dla pageNumber = {}", defaultPageSize, pageNumber);
            return this.carRepository.pobierzWolneAuta(PageRequest.of(pageNumber, defaultPageSize)).getContent();
        }

        if(pageNumber == null){
            log.info("Zaczynam wyswietlac dane od poczatku");
            return this.carRepository.pobierzWolneAuta(PageRequest.of(0, pageSize)).getContent();
        }

        return this.carRepository.pobierzWolneAuta(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    public Car zapiszSamochod(Car samochod) {
        log.info("Trafiles pod zapis samochodu {}", samochod);
        return this.carRepository.save(samochod);
    }

    public Optional<Car> pobierzSamochod(int idSamochodu) {
        return this.carRepository.findById(idSamochodu);
    }

    public Car getCarByRental(Integer idRental){
        return this.carRepository.findById(idRental).get();
    }
}
