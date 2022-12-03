package pl.sda.j133.hiberanate.warsztat.komendy;

import pl.sda.j133.hiberanate.warsztat.DataAccessObject;
import pl.sda.j133.hiberanate.warsztat.model.Mechanik;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaUsunMechanik implements Komenda {
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaUsunMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego mechanika:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.delete(Mechanik.class, id)){
            System.out.println("Usunięto mechanika!");
        }else{
            System.err.println("Nie udało się usunąć mechanika!");
        }
    }
}
