package wypozyczalnia.samochodow.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "uzytkownik")
@Getter
@Setter
@ToString
public class Uzytkownik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownik")
    private int idUzytkownik;

    @Column( name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "nazwa_uzytkownika")
    private String username;

    @Column(name = "haslo")
    private String password;

    @Value("${czy.potwierdzone.haslo}")
    @Transient
    private String passwordConfirm;

    @ManyToMany(mappedBy = "users")
    private Set<Rola> roles;

    public Uzytkownik() {
//        konstruktor na potrzeby hibernate
    }
}
