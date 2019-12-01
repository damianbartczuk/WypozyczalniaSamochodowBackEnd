package wypozyczalnia.samochodow.demo.serwisy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Uzytkownik;
import wypozyczalnia.samochodow.demo.repozytorium.RolaRepository;
import wypozyczalnia.samochodow.demo.repozytorium.UzytkownikRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @Autowired
    private RolaRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Uzytkownik user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        uzytkownikRepository.save(user);
    }

    @Override
    public Uzytkownik findByUsername(String username) {
        return uzytkownikRepository.findByUsername(username);
    }
}
