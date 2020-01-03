package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.serwisy.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localgost:4200", exposedHeaders = "Authorization")
@RestController
@Slf4j
@AllArgsConstructor
@Api(tags = "User API")
@RequestMapping(value = "api/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @ApiOperation(value = "Pobiera informacje na temat użytkowników")
    @GetMapping( value = "pobierz_uzytkownikow")
    public ResponseEntity<List<User>> pobierzUzytkownikow() {
        log.info("Pobranie uzytkownikow");
        return new ResponseEntity<>(this.userService.odczytUzytkownikow(), HttpStatus.OK);
    }

    @ApiOperation(value = "Zapisuje użytkownika, kodowanie hasła jest na poziomie kontrolera")
    @PostMapping( value = "zapisz_uzytkownika")
    public ResponseEntity<User> zapiszUzytkownika(@PathVariable User userToSave) {
        log.info("Zapis uzytkownika = {}", userToSave);
        return new ResponseEntity<>(this.userService.zapiszUzytkownika(userToSave), HttpStatus.OK);
    }
}
