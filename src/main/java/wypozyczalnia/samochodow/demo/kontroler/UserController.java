package wypozyczalnia.samochodow.demo.kontroler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.repozytorium.UserRepository;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("pobierz_uzytkownikow")
    public List<User> pobierzUzytkownikow() {
        return this.userRepository.findAll();
    }

    @PostMapping("zapisz_uzytkownika")
    public User zapiszUzytkownika(@RequestBody User user) {
        log.info("Trafiles pod zapis uzytkownika {}", user);
        return this.userRepository.save(user);
    }
}
