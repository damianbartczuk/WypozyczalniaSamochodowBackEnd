package wypozyczalnia.samochodow.demo;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
@ComponentScan({"wypozyczalnia.samochodow.demo.jwtauth", "wypozyczalnia.samochodow.demo.konfiguracja",
		"wypozyczalnia.samochodow.demo.kontroler", "wypozyczalnia.samochodow.demo.model",
		"wypozyczalnia.samochodow.demo.repozytorium", "wypozyczalnia.samochodow.demo.serwisy"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public SpringLiquibase liquibase(DataSource datasource) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase-ChangeLog.xml");
		liquibase.setDataSource(datasource);
		return liquibase;
	}
}
