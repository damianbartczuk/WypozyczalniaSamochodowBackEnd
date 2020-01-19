package wypozyczalnia.samochodow.demo.jwtauth;

import org.springframework.security.core.GrantedAuthority;
import wypozyczalnia.samochodow.demo.model.Role;

public class MyGrantedAuthority implements GrantedAuthority {
    private String  nazwaRoli;

    public MyGrantedAuthority(Role role) {
        this.nazwaRoli = role.getNazwa();
    }

    @Override
    public String getAuthority() {
        return this.nazwaRoli;
    }
}
