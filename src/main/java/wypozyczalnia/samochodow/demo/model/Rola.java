package wypozyczalnia.samochodow.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

//    @ManyToMany(mappedBy = "roles")


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "uzytkownik_rola", joinColumns = {
            @JoinColumn(name = "id_rola") },
            inverseJoinColumns = { @JoinColumn(name = "id_uzytkownik")})
    @JsonIgnore
    private Set<Uzytkownik> users;

    public Rola(){}
}
