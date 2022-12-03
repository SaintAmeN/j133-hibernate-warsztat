package pl.sda.j133.hiberanate.warsztat;

import pl.sda.j133.hiberanate.warsztat.komendy.Komenda;
import pl.sda.j133.hiberanate.warsztat.komendy.KomendaDodajPojazd;

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
                        new KomendaDodajPojazd()
                )
        );

        System.out.println("Lista dostępnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("Podaj komende:");
        String komenda = Komenda.scanner.nextLine();

        for (Komenda dostepnaKomenda : listaKomend) {
            if(dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)){
                dostepnaKomenda.obsluga();
            }
        }
    }
}
