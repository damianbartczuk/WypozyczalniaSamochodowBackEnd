package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Role;
import wypozyczalnia.samochodow.demo.repozytorium.RoleRepository;

import java.util.List;


@Api(tags = "Role API")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("api/Role")
@RestController
@Slf4j
public class RoleController {

    private RoleRepository roleRepository;

    @GetMapping(value = "pobierz_role")
    public List<Role> pobierzWszystkieRole() {
        return this.roleRepository.findAll();
    }

}
