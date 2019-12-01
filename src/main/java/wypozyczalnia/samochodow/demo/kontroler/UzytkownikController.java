package wypozyczalnia.samochodow.demo.kontroler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.walidator.UserValidator;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.repozytorium.UzytkownikRepository;
import wypozyczalnia.samochodow.demo.serwisy.SecurityService;
import wypozyczalnia.samochodow.demo.serwisy.UserService;

import java.util.List;

@RestController
@Slf4j
public class UzytkownikController {

    @Autowired
    private UzytkownikRepository uzytkownikRepository;


    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("pobierz_uzytkownikow")
    public List<Uzytkownik> pobierzUzytkownikow() {
        log.info("Trafiles pod odczyt uzytkownikow");
        return this.uzytkownikRepository.findAll();
    }

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }

//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
//
//        return "redirect:/welcome";
//    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
