package wypozyczalnia.samochodow.demo.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "samochod")
@Entity
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Samochod")
    private int id;

    @Column(name = "marka")
    private String marka;

    @Column(name = "model")
    private String model;

    @Column(name = "logo")
    private String logo;

    @Column(name = "opis")
    private String opis;

    @Column(name = "cena_za_dobe")
    private int cenaZaDobe;

    @Column(name = "czy_wypozyczony")
    private boolean czyWypozyczony;

    public Car(){}


}
