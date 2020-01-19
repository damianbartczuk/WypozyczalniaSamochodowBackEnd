package wypozyczalnia.samochodow.demo;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
//@EnableSwagger2
@SpringBootApplication
public class WypozyczalniaSamochodApplication {
	private static final Logger log = LoggerFactory.getLogger(WypozyczalniaSamochodApplication.class);
	public static void main(String[] args) {
		log.info("============================================================");
		log.info("java version : {}", System.getProperty("java.runtime.version" ));
		log.info("============================================================");
		SpringApplication.run(WypozyczalniaSamochodApplication.class, args);
	}

	@Bean
	public SpringLiquibase liquibase(DataSource datasource) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase-ChangeLog.xml");
		liquibase.setDataSource(datasource);
		return liquibase;
	}
}
