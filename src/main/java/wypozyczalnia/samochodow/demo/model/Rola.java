package wypozyczalnia.samochodow.demo.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private Long id;

    @Column(name = "nazwa")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Uzytkownik> users;

    public Rola(){}
}
