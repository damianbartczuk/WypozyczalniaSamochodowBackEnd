package wypozyczalnia.samochodow.demo.kontroler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Role;
import wypozyczalnia.samochodow.demo.repozytorium.RoleRepository;

import java.util.List;

@RestController
@Slf4j
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "pobierz_role")
    public List<Role> pobierzWszystkieRole() {
        return this.roleRepository.findAll();
    }

    @GetMapping("pobierz_konkretne_role")
    public List<Role> pobierzKonkretneRole(){
        return this.roleRepository.findAll();
    }
}
