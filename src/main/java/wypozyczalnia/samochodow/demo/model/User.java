package wypozyczalnia.samochodow.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "uzytkownik")
@Getter
@Setter
@ToString
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

    @Transient
    private String passwordConfirm;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    public User(){}
}
