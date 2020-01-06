package wypozyczalnia.samochodow.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRental;

    @NotNull(message = "Id samochodu nie moża być nullem")
    @NotEmpty(message = "Id samochodu nie moża być puste")
    private int idCar;

    @NotEmpty(message = "Id użytkownika nie moża być puste")
    @NotNull(message = "Id użytkownika nie moża być nullem")
    private int idUser;
}
