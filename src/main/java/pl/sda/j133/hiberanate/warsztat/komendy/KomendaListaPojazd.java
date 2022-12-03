package pl.sda.j133.hiberanate.warsztat.komendy;

import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.model.Pojazd;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaListaPojazd implements Komenda{
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaListaPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista pojazd";
    }

    @Override
    public void obsluga() {
        List<Pojazd> pojazdy = dataAccessObject.findAll(Pojazd.class);
        pojazdy.forEach(System.out::println);
    }
}
