package pl.sda.j133.hiberanate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hiberanate.warsztat.HibernateUtil;
import pl.sda.j133.hiberanate.warsztat.model.Mechanik;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public class KomendaDodajMechanik implements Komenda{
    @Override
    public String getKomenda() {
        return "dodaj mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie mechanika:");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje mechanika:");
        String kwalifikacje = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizacje mechanika:");
        String specjalizacja = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik.builder()
                .specjalizacja(specjalizacja)
                .kwalifikacje(kwalifikacje)
                .imie(imie)
                .build();

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(mechanik);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }
}
