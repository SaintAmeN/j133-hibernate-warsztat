package pl.sda.j133.hiberanate.warsztat.komendy;

import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.model.Pojazd;
import pl.sda.j133.hiberanate.warsztat.model.SerwisPojazdu;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaZakonczSerwisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZakonczSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "zakoncz serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id serwisu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        // sprawdz czy rekord istnieje zanim podasz X dodatkowych danych.
        Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, id);
        if(serwisPojazduOptional.isEmpty()){
            System.err.println("Zlecenie serwisowe o takim id nie istnieje!");
            return;
        }
        SerwisPojazdu orginalnySerwisPojazdu = serwisPojazduOptional.get();

        System.out.println("Podaj zrealizowane czynnosci:");
        String czynnosci = Komenda.scanner.nextLine();

        System.out.println("Podaj koszt serwisu:");
        String kosztString = Komenda.scanner.nextLine();
        Double koszt = Double.parseDouble(kosztString);

        SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
                .czasDodania(orginalnySerwisPojazdu.getCzasDodania())
                .opis(orginalnySerwisPojazdu.getOpis())
                // powyżej mamy dwa pola które bierzemy z orginalnego(aktualizowanego) rekordu z bazy
                .czasZrealizowania(LocalDateTime.now())
                .zrealizowaneCzynnosci(czynnosci)
                .koszt(koszt)
                .id(id) // dopisujemy ID ponieważ do aktualizacji musimy podać ID aktualizowanego rekordu, jeśli go nie podamy to zostanie dodany nowy rekord
                .build();

        dataAccessObject.update(SerwisPojazdu.class, id, serwisPojazdu);
    }
}
