package wypozyczalnia.samochodow.demo.jwtauth;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtRequestFilter.class);
    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
            request.authenticate(response);
            log.info("header content type = {}", request.getHeader("Content-Type"));
            log.info("header Authorization = {}", request.getHeader("Authorization"));
            log.info("header repote user = {}", request.getRemoteUser());
            log.info("request url {}", request.getRequestURL());
            log.info("zaczynam filtrowac");
            String requestTokenHeader = request.getHeader("Authorization");
            log.info("wyslany token = {}", requestTokenHeader);
//requestTokenHeader = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYmFydGN6dWsiLCJleHAiOjE1Nzg5NzA3NTcsImlhdCI6MTU3ODk1Mjc1N30.WPFBmWBhJHeRBoSLFTgyGLt2S1HGELZJY72fZcXboe4Qf8C2DA271Ec3iSKGfIUjJ499rpxP4Aqr9K_SbjAUkQ";
            String username = null;
            String jwtToken = null;

            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);
                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                    log.info("username = {}", username);
                } catch (IllegalArgumentException e) {
                    log.debug("Unable to get JWT Token");
                } catch (ExpiredJwtException e) {
                    log.debug("JWT Token has expired");
                }
            } else {
                logger.warn("JWT Token is null oraz not conains bearer prefix");
            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
                boolean isCorrectToken = jwtTokenUtil.validateToken(jwtToken, userDetails);
                if (isCorrectToken) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            chain.doFilter(request, response);
    }
}
