package wypozyczalnia.samochodow.demo.kontroler;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.samochodow.demo.enumy.RolaEnum;
import wypozyczalnia.samochodow.demo.jwtauth.JwtTokenUtil;
import wypozyczalnia.samochodow.demo.model.Role;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.model.UserRole;
import wypozyczalnia.samochodow.demo.repozytorium.UserRoleRepository;
import wypozyczalnia.samochodow.demo.serwisy.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
//@Api(tags = "User API")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private JwtTokenUtil jwtTokenUtil;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserController(UserService userService, JwtTokenUtil jwtTokenUtil, UserRoleRepository userRoleRepository){
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping(value = "pobierz_uzytkownika_za_pomoca_tokenu")
    public ResponseEntity<User> pobierzUzytkownikaZTokenu(@RequestParam(value = "token") String token) {
        String username = this.jwtTokenUtil.getUsernameFromToken(token);
        User user = userService.findByUsername(username);
        List<UserRole> roleUzytkownika = userRoleRepository.findAll();
        Set<Role> roleZalogowanegoUzytkownika = new HashSet<>();
        for (UserRole ur : roleUzytkownika) {
            Set<User> uzytkownicy = ur.getUsers();
            if(uzytkownicy.stream().anyMatch(u -> u.getIdUzytkownik() == user.getIdUzytkownik())) {
                RolaEnum rolaEnum = pobierzRole(ur.getIdRola());
                roleZalogowanegoUzytkownika.add(new Role(Long.valueOf(ur.getIdRola()), rolaEnum.getNazwa(), null));
            }
        }

        user.setRoles(new HashSet<>(roleZalogowanegoUzytkownika.stream().distinct().collect(Collectors.toList())));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private RolaEnum pobierzRole(String idRola) {
        switch (idRola) {
            case "1": {
                return RolaEnum.MANAGER;
            } case "2": {
                return RolaEnum.ADMIN;
            } default: {
                throw new IllegalArgumentException();
            }
        }
    }

    //    @ApiOperation(value = "Pobiera informacje na temat użytkowników")
    @GetMapping( value = "pobierz_uzytkownikow")
    public ResponseEntity<Page<User>> pobierzUzytkownikow(Pageable pageable) {
        log.info("Pobranie uzytkownikow");
        return new ResponseEntity<>(this.userService.odczytUzytkownikow(pageable), HttpStatus.OK);
    }

//    @ApiOperation(value = "Zapisuje użytkownika, kodowanie hasła jest na poziomie kontrolera")
    @PostMapping( value = "zapisz_uzytkownika")
    public ResponseEntity<User> zapiszUzytkownika(@RequestBody User userToSave) {
        log.info("Zapis uzytkownika = {}", userToSave);
        return new ResponseEntity<>(this.userService.zapiszUzytkownika(userToSave), HttpStatus.OK);
    }
}
