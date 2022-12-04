package pl.sda.j133.hiberanate.warsztat.komendy;

import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.model.Mechanik;
import pl.sda.j133.hiberanate.warsztat.model.Pojazd;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaAktualizujPojazd implements Komenda {
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaAktualizujPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id pojazdu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        // sprawdz czy rekord istnieje zanim podasz X dodatkowych danych.
        if (!dataAccessObject.exists(Pojazd.class, id)) {
            System.err.println("Błąd, pojazd o takim id nie istnieje!");
            return;
        }

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
                .id(id) // dopisujemy ID ponieważ do aktualizacji musimy podać ID aktualizowanego rekordu
                .build();

        dataAccessObject.update(Pojazd.class, id, pojazd);
    }
}
