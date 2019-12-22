package wypozyczalnia.samochodow.demo.serwisy;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authorityName;

    public GrantedAuthorityImpl(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public String getAuthority() {
        return this.authorityName;
    }
}
