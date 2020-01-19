package wypozyczalnia.samochodow.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@Table(name = "wypozyczenie")
@AllArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idwypozyczenia")
    private int idRental;

    @NotNull(message = "Id samochodu nie moża być nullem")
    @Column(name = "idsamochodu")
    private Integer idCar;

    @NotNull(message = "Id uzytkownika nie moża być nullem")
    @Column(name = "iduzytkownika")
    private Integer idUser;

    public Rental(){
//        konstruktor na potrzeby hibernate
    }
}
