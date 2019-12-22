package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.serwisy.UzytkownikService;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@AllArgsConstructor
@Api(tags = "Uzytkownik API")
@RequestMapping(value = "uzytkownik")
public class UzytkownikController {

    private UzytkownikService uzytkownikService;

    @ApiOperation(value = "Pobiera informacje na temat użytkowników")
    @GetMapping("pobierz_uzytkownikow")
    public ResponseEntity<List<Uzytkownik>> pobierzUzytkownikow() {
        return new ResponseEntity<>(this.uzytkownikService.odczytUzytkownikow(), HttpStatus.OK);
    }

    @ApiOperation(value = "Zapisuje użytkownika, kodowanie hasła jest na poziomie kontrolera")
    @PostMapping("zapisz_uzytkownika")
    public ResponseEntity<Uzytkownik> zapiszUzytkownika(@PathVariable Uzytkownik uzytkownik) {
        return new ResponseEntity<>(this.uzytkownikService.zapiszUzytkownika(uzytkownik), HttpStatus.OK);
    }
}
