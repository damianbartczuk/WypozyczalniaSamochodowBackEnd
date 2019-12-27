package wypozyczalnia.samochodow.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "uzytkownik_rola")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownik_rola")
    private Long idUzytkownikRola;

    @Column(name = "id_uzytkownik")
    private String idUzytkownik;

    @Column(name = "id_rola")
    private String idRola;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public UserRole(){
        //        konstruktor na potrzeby hibernate
    }

}
