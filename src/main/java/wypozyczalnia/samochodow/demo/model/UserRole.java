package wypozyczalnia.samochodow.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @ManyToMany( mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public UserRole(){
        //        konstruktor na potrzeby hibernate
    }

}
