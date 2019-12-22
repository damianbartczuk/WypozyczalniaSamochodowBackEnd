package wypozyczalnia.samochodow.demo.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Table(name = "samochod")
@Entity
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Samochod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Samochod")
    private int id;
    
    @NotEmpty(message = "Marka cannot me empty")
    @Column(name = "marka")
    private String marka;

    @NotEmpty(message = "Model cannot be empty")
    @Column(name = "model")
    private String model;

    @NotEmpty(message = "Logo cannot be empty")
    @Column(name = "logo")
    private String logo;

    @NotEmpty( message = "Opis cannot be empty")
    @Column(name = "opis")
    private String opis;

    @Min(100)
    @Column(name = "cena_za_dobe")
    private int cenaZaDobe;

    @Value("${default.value.for.czyWypozyczony.field}")
    @Column(name = "czy_wypozyczony")
    private boolean czyWypozyczony;

    public Samochod(){}


}
