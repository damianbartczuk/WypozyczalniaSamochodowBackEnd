package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Rental;
import wypozyczalnia.samochodow.demo.serwisy.RentalService;

@Api(tags = "Rental API")
@CrossOrigin
@AllArgsConstructor
@RestController
@Slf4j
public class RentalController {

    private RentalService rentalService;

    @PostMapping("/save_rental")
    public ResponseEntity<Rental> saveRental(@RequestParam Integer idCar, @RequestParam Integer idUser) {
        log.info("Zapisuje wypozyczenie samochodu");
        return new ResponseEntity<>(this.rentalService.saveRental(idCar, idUser), HttpStatus.OK);
    }
}
