package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.model.Rental;
import wypozyczalnia.samochodow.demo.serwisy.RentalService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
@AllArgsConstructor
@RestController
@Slf4j
public class RentalController {

    private RentalService rentalService;

    @PostMapping("/save_rental")
    public ResponseEntity<Rental> saveRental( @RequestBody Integer idCar, HttpServletRequest request) {
        log.info("Zapisuje wypozyczenie samochodu {}", request.getHeader("Authorization"));
        final String token = request.getHeader("Authorization");
        return new ResponseEntity<>(this.rentalService.saveRental(idCar, token), HttpStatus.OK);
    }

    @GetMapping( value = "/get_rental/{id}")
    public ResponseEntity<List<Car>> getRentalForSpecificId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.rentalService.getCarBasedOnRental(id), HttpStatus.OK);
    }
}
