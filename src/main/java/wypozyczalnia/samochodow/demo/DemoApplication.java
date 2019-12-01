package wypozyczalnia.samochodow.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import wypozyczalnia.samochodow.demo.kontroler.SamochodController;
import wypozyczalnia.samochodow.demo.model.Samochod;
import wypozyczalnia.samochodow.demo.repozytorium.SamochodRepository;

@SpringBootApplication
@Slf4j
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		log.info("ClassPath: " + System.getProperty(System.getProperty("java.class.path")));
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);

	}
}
