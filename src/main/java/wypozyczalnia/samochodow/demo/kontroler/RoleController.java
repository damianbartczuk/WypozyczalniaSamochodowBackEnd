package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.samochodow.demo.model.Role;
import wypozyczalnia.samochodow.demo.repozytorium.RoleRepository;


@Api(tags = "Role API")
@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
@AllArgsConstructor
@RestController
public class RoleController {

    private RoleRepository roleRepository;

    @GetMapping(value = "pobierz_role")
    public Page<Role> pobierzWszystkieRole(Pageable pageable) {
        return this.roleRepository.findAll(pageable);
    }

}
