package wypozyczalnia.samochodow.demo.konfiguracja;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(SpringConfig.class);
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("AddCorsMapping");
        registry.addMapping("/**").allowCredentials(true).allowedOrigins("http://localhost:4200/zaloguj")
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type", "Accept", "X-Requested-With", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin")
                .exposedHeaders("Access-Control-Expose-Headers", "Authorization", "Content-Type", "Access-Control-Allow-Origin")
                .allowedMethods("GET", "OPTIONS", "POST", "PUT", "DELETE", "PATCH");
    }
}
