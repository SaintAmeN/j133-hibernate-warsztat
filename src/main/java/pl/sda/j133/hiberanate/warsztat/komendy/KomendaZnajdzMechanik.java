package pl.sda.j133.hiberanate.warsztat.komendy;

import org.hibernate.Session;
import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.HibernateUtil;
import pl.sda.j133.hiberanate.warsztat.model.Mechanik;

import java.util.Optional;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaZnajdzMechanik implements Komenda {
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaZnajdzMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id szukanego mechanika:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<Mechanik> mechanikOptional = dataAccessObject.find(Mechanik.class, id);
        if (mechanikOptional.isPresent()) {
            System.out.println(mechanikOptional.get());
        } else {
            System.err.println("Nie znaleziono mechanika!");
        }
    }
}
