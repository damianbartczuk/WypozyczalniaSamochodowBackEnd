package wypozyczalnia.samochodow.demo.kontroler;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import wypozyczalnia.samochodow.demo.jwtauth.JwtRequest;
import wypozyczalnia.samochodow.demo.jwtauth.JwtResponse;
import wypozyczalnia.samochodow.demo.jwtauth.JwtTokenUtil;
import wypozyczalnia.samochodow.demo.jwtauth.JwtUserDetailsService;


@Api(tags = "Authentication API")
@Slf4j
@AllArgsConstructor
@RequestMapping("api/Car")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {
    private static final String INVALID_CREDENTIALS = "INVALID_CREDENTIALS";
    private static final String USER_DISABLED = "USER_DISABLED";
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;
    private JwtUserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Endpoint do autoryzacji
     * @param authenticationRequest
     * @return 200 gdy istnieje user o podanych username oraz password
     * @throws Exception
     */
    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception(USER_DISABLED, e);
        } catch (BadCredentialsException e) {
            throw new Exception(INVALID_CREDENTIALS, e);
        }
    }
}
