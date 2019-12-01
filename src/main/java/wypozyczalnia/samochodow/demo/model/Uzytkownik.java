package wypozyczalnia.samochodow.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "uzytkownik")
@Getter
@Setter
public class Uzytkownik {
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "uzytkownik_rola", joinColumns = {
            @JoinColumn(name = "id_uzytkownik") },
            inverseJoinColumns = { @JoinColumn(name = "id_rola")})
    @JsonIgnore
    private Set<Rola> roles;

    public Uzytkownik(){}
}
