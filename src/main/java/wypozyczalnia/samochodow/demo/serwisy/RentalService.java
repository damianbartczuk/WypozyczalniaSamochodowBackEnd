package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.jwtauth.JwtTokenUtil;
import wypozyczalnia.samochodow.demo.model.Car;
import wypozyczalnia.samochodow.demo.model.Rental;
import wypozyczalnia.samochodow.demo.model.User;
import wypozyczalnia.samochodow.demo.repozytorium.RentalRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalService {

    private RentalRepository rentalRepository;
    private JwtTokenUtil jwtTokenUtil;
    @PersistenceContext
    private EntityManager entityManager;

    private CarService carService;


    public Rental saveRental(Integer idCar, String token) {
        int idUserToSaveRental = getIdUserToSaveRental(token);
        final Rental rentalToSave = prepareRentalToSave(idCar, idUserToSaveRental);
        return this.rentalRepository.save(rentalToSave);
    }

    private int getIdUserToSaveRental(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token.substring(7));
        return entityManager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult().getIdUzytkownik();
    }

    private Rental prepareRentalToSave(Integer idCar, Integer idUser) {
        return Rental.builder()
                .idCar(idCar)
                .idUser(idUser)
                .build();
    }

    private void weryfikujParametryWejsciowe(Integer idCar, Integer idUser) {
        if(idCar == null || idUser == null) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCarBasedOnRental(Integer id) {
        List<Rental> listaWypozyczenSamochodow = new ArrayList<>();
        List<Car> listaWypozyczonychSamochodow = new ArrayList<>();

        if(id != null){
            listaWypozyczenSamochodow =  this.rentalRepository.pobierzWypozyczoneSamochodyZalogowanegoUzytkownika(id);
        }

        for (Rental r: listaWypozyczenSamochodow) {
            int idCarRentedByUser = r.getIdCar();
            Car rentedCar = carService.getCarByRental(idCarRentedByUser);
            listaWypozyczonychSamochodow.add(rentedCar);
        }

        return listaWypozyczonychSamochodow;
    }
}
