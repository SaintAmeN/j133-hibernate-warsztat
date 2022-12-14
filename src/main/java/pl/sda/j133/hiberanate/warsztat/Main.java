package pl.sda.j133.hiberanate.warsztat;

import pl.sda.j133.hiberanate.warsztat.komendy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajPojazd(),
                        new KomendaDodajMechanik(),
                        new KomendaDodajSerwisPojazdu(),
                        new KomendaListaPojazd(),
                        new KomendaListaMechanik(),
                        new KomendaListaSerwisPojazdu(),
                        new KomendaZnajdzPojazd(),
                        new KomendaZnajdzMechanik(),
                        new KomendaZnajdzSerwisPojazdu(),
                        new KomendaUsunPojazd(),
                        new KomendaUsunMechanik(),
                        new KomendaUsunSerwisPojazdu(),
                        new KomendaAktualizujPojazd(),
                        new KomendaAktualizujMechanik(),
                        new KomendaZakonczSerwisPojazdu()
                )
        );

        System.out.println("Lista dostępnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("Podaj komende:");
        String komenda = Komenda.scanner.nextLine();

        for (Komenda dostepnaKomenda : listaKomend) {
            if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                dostepnaKomenda.obsluga();
            }
        }
    }
}
