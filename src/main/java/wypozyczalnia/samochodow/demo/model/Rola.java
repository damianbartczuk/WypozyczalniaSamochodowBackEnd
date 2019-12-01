package wypozyczalnia.samochodow.demo.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Rola")
@Table(name = "rola")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Rola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rola")
    private Long idRola;

    @Column(name = "nazwa")
    private String nazwa;

    @ManyToMany(mappedBy = "roles")
    private Set<Uzytkownik> users;

    public Rola(){}
}
