package wypozyczalnia.samochodow.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "wypozyczenie")
@AllArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_wypozyczenie")
    private int idRental;

    @NotNull(message = "Id samochodu nie moża być nullem")
    @Column(name = "id_samochodu")
    private Integer idCar;

    @NotNull(message = "Id uzytkownika nie moża być nullem")
    @Column(name = "id_uzytkownika")
    private Integer idUser;

    @Column(name = "data_od")
    private LocalDate dataOd;

    @Column(name = "data_do")
    private LocalDate dataDo;

    public Rental(){
//        konstruktor na potrzeby hibernate
    }


}
