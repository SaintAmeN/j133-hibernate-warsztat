package pl.sda.j133.hiberanate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.HibernateUtil;
import pl.sda.j133.hiberanate.warsztat.model.Mechanik;
import pl.sda.j133.hiberanate.warsztat.model.Pojazd;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaDodajPojazd implements Komenda{
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaDodajPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj marke pojazdu:");
        String marke = Komenda.scanner.nextLine();

        System.out.println("Podaj model pojazdu:");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj vin pojazdu:");
        String vin = Komenda.scanner.nextLine();

        System.out.println("Podaj nr rejestracyjny pojazdu:");
        String nrRej = Komenda.scanner.nextLine();

        Pojazd pojazd = Pojazd.builder()
                .marka(marke)
                .model(model)
                .nrRej(nrRej)
                .vin(vin)
                .build();

        dataAccessObject.insert(pojazd);
    }
}
