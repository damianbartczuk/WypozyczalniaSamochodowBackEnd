package wypozyczalnia.samochodow.demo.serwisy;

import wypozyczalnia.samochodow.demo.model.Uzytkownik;

public interface UserService {
    void save(Uzytkownik user);

    Uzytkownik findByUsername(String username);
}
