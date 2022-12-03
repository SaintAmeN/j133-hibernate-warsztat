package pl.sda.j133.hiberanate.warsztat.komendy;

import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.model.Mechanik;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaListaMechanik implements Komenda{
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaListaMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {
        List<Mechanik> mechanicy = dataAccessObject.findAll(Mechanik.class);
        mechanicy.forEach(System.out::println);
    }
}
