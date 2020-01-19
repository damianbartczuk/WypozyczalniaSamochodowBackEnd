package wypozyczalnia.samochodow.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "uzytkownik")
@Getter
@Setter
public class User {
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
    private Set<Role> roles;

    public User(){
        // konstruktor na potrzeby hibernate
    }

    @Override
    public String toString() {
        return "User{" +
                "idUzytkownik=" + idUzytkownik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", roles=" + roles +
                '}';
    }
}
