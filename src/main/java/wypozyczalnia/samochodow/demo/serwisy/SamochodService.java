package wypozyczalnia.samochodow.demo.serwisy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wypozyczalnia.samochodow.demo.model.Samochod;
import wypozyczalnia.samochodow.demo.repozytorium.SamochodRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SamochodService {

    private SamochodRepository samochodRepository;

    public List<Samochod> odczytSamochodow(){
        log.info("Odczytujemy samochody w serwisie posortowanych po marce");
        return this.samochodRepository.findAll(Sort.by(Sort.Direction.ASC, "marka"));
    }
    public Samochod zapiszSamochod(Samochod samochod) {
        log.info("Trafiles pod zapis samochodu {}", samochod);
        return this.samochodRepository.save(samochod);
    }
}
