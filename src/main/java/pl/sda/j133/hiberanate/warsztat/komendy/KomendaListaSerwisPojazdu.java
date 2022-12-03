package pl.sda.j133.hiberanate.warsztat.komendy;

import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.model.Pojazd;
import pl.sda.j133.hiberanate.warsztat.model.SerwisPojazdu;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaListaSerwisPojazdu implements Komenda{
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaListaSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista serwis";
    }

    @Override
    public void obsluga() {
        List<SerwisPojazdu> serwisy = dataAccessObject.findAll(SerwisPojazdu.class);
        serwisy.forEach(System.out::println);
    }
}
