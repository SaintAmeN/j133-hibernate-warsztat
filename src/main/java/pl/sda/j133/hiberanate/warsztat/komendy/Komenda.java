package pl.sda.j133.hiberanate.warsztat.komendy;

import java.util.Scanner;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
public interface Komenda {
    public static final Scanner scanner = new Scanner(System.in);

    String getKomenda();
    void obsluga();
}
