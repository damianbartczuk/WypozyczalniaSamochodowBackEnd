package wypozyczalnia.samochodow.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity(name = "Rola")
@Table(name = "rola")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rola")
    private Long idRola;

    @Column(name = "nazwa")
    @NotEmpty(message = "Name of role cannot be empty")
    private String nazwa;

    @ManyToMany()
    @JoinTable(name = "uzytkownik_rola", joinColumns = {
            @JoinColumn(name = "id_rola") },
            inverseJoinColumns = { @JoinColumn(name = "id_uzytkownik")})
    @JsonIgnore
    private List<User> users;

    public Role() {
        // konstruktor na potrzeby hibernate
    }

    @Override
    public String toString() {
        return "User = " + this.getNazwa();
    }
}
