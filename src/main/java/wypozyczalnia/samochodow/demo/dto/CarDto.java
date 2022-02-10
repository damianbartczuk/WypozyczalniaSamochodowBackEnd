package wypozyczalnia.samochodow.demo.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import wypozyczalnia.samochodow.demo.model.Car;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class CarDto {

    private int id;
    private String marka;
    private String model;
    private String logo;
    private String opis;
    private int cenaZaDobe;
    private boolean czyWypozyczony;
    private LocalDate dataOd;
    private LocalDate dataDo;
}
