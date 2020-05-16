package wypozyczalnia.samochodow.demo.konfiguracja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import wypozyczalnia.samochodow.demo.jwtauth.JwtAuthenticationEntryPoint;
import wypozyczalnia.samochodow.demo.jwtauth.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private UserDetailsService jwtUserDetailsService;
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public WebSecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserDetailsService jwtUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests().antMatchers("/authenticate").permitAll()
//                .antMatchers("/pobierz_uzytkownikow", "/save_rental", "pobierz_uzytkownika_za_pomoca_tokenu", "/pobierz_samochody")
//                .authenticated()
                .and()
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

//
///**
// * This class defines the Spring Security configuration for the web application.
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//
//    /**
//     * Defines what queries should be used for verifying users and loading their permissions, in addition to the data source and the method of processing passwords.
//     * @param auth the AuthenticationManagerBuilder to configure
//     */
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new PasswordEncoder())
//                .usersByUsernameQuery("SELECT username,password, 1 as enabled FROM \"USER\" WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT username, permissions FROM \"USER\",\"ROLE\" WHERE \"USER\".\"ROLE\" = \"ROLE\".id AND username=?");
//    }
//
//    /**
//     * Defines the HttpSecurity configuration to enforce authentication for endpoints and restrict access to certain endpoints based on permissions.
//     * Established rules
//     * <p>
//     *     <ul>
//     *         <li>Each user can get or edit his user object</li>
//     *         <li>User data is accessible only to ADMINs</li>
//     *         <li>Insert/Delete/Edit endpoints are accessible only to ADMIN users</li>
//     *         <li>Users with REPORT_ONLY roles can only access reports endpoints</li>
//     *         <li>Users with VIEW roles can access all data retrieval endpoints except those under /user</li>
//     *     </ul>
//     * </p>
//     * @param http The HttpSecurity object to configure
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .and().csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/getCurrent/**").authenticated()
//                .antMatchers("/user/editCurrent/**").authenticated()
//                .regexMatchers("^.*user.*$").hasAuthority("ADMIN")
//                .regexMatchers("^.*insert.*$").hasAuthority("ADMIN")
//                .regexMatchers("^.*delete.*$").hasAuthority("ADMIN")
//                .regexMatchers("^.*edit.*$").hasAuthority("ADMIN")
//                .regexMatchers("^((?!reports).)*$").hasAnyAuthority("VIEW","ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .successHandler(new MySavedRequestAwareAuthenticationSuccessHandler())
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
//                .logout();
//    }
//}
