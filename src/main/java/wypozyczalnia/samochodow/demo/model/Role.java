package wypozyczalnia.samochodow.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Rola")
@Table(name = "rola")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rola")
    private Long idRola;

    @Column(name = "nazwa")
    @NotEmpty(message = "Name of role cannot be empty")
    private String nazwa;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "uzytkownik_rola", joinColumns = {
            @JoinColumn(name = "id_rola") },
            inverseJoinColumns = { @JoinColumn(name = "id_uzytkownik")})
    @JsonIgnore
    private Set<User> users;

    public Role() {
        // konstruktor na potrzeby hibernate
    }
}
