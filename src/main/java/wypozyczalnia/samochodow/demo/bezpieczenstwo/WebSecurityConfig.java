package wypozyczalnia.samochodow.demo.bezpieczenstwo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails userDetaiuls = User.withDefaultPasswordEncoder()
                .username("damian")
                .password("0000")
                .roles("admin").build();
        return new InMemoryUserDetailsManager(userDetaiuls);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/pobierz_role").hasRole("admin")
                .antMatchers("/pobierz_samochody").hasRole("admin")
                .antMatchers("/").permitAll();

        super.configure(http);
    }
}
