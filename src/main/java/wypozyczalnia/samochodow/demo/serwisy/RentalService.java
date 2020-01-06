package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Rental;
import wypozyczalnia.samochodow.demo.repozytorium.RentalRepository;

@Service
@AllArgsConstructor
public class RentalService {

    private RentalRepository rentalRepository;

    /**
     *
     * @param idCar
     * @param idUser
     * @return saved Rental
     */
    public Rental saveRental(Integer idCar, Integer idUser) {
        weryfikujParametryWejsciowe(idCar, idUser);

        final Rental rentalToSave = prepareRentalToSave(idCar, idUser);
        return this.rentalRepository.save(rentalToSave);
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
}
