package wypozyczalnia.samochodow.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import wypozyczalnia.samochodow.demo.kontroler.SamochodController;
import wypozyczalnia.samochodow.demo.model.Samochod;
import wypozyczalnia.samochodow.demo.repozytorium.SamochodRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
