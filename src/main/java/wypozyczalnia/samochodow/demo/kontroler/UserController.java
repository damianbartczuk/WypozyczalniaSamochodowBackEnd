package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.jwtauth.JwtTokenUtil;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.serwisy.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "User API")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserController(UserService userService, JwtTokenUtil jwtTokenUtil){
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping(value = "pobierz_uzytkownika_za_pomoca_tokenu")
    public ResponseEntity<User> pobierzUzytkownikaZTokeny(@RequestParam(value = "token") String token){
        String username = this.jwtTokenUtil.getUsernameFromToken(token);
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Pobiera informacje na temat użytkowników")
    @GetMapping( value = "pobierz_uzytkownikow")
    public ResponseEntity<Page<User>> pobierzUzytkownikow(Pageable pageable) {
        log.info("Pobranie uzytkownikow");
        return new ResponseEntity<>(this.userService.odczytUzytkownikow(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Zapisuje użytkownika, kodowanie hasła jest na poziomie kontrolera")
    @PostMapping( value = "zapisz_uzytkownika")
    public ResponseEntity<User> zapiszUzytkownika(@PathVariable User userToSave) {
        log.info("Zapis uzytkownika = {}", userToSave);
        return new ResponseEntity<>(this.userService.zapiszUzytkownika(userToSave), HttpStatus.OK);
    }
}
