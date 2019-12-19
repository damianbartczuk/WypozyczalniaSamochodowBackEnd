package wypozyczalnia.samochodow.demo.konfiguracja;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("damianbartczuk-apiWypozyczalniaSamochodow")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(value -> value.matches("/api.*") || value.matches("/test.*"))
                .build()
                .globalResponseMessage(RequestMethod.GET,getListOfResponseMessages());
    }

    private List<ResponseMessage>getListOfResponseMessages() {
        return Arrays.asList(
                new ResponseMessageBuilder().code(200)
                        .message("Everything is ok")
                        .responseModel(new ModelRef("OK"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal server error").build()
        );
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Damian Bartczuk Car Rental")
                .description("Swagger for car rental")
                .contact(new Contact("Damian Bartczuk",
                        "http://users.pja.edu.pl/s17763/",
                        "s17763@pjwstk.edu.pl"))
                .version("1.0.0")
                .build();
    }

}
