package pl.sda.j133.hiberanate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * @author Paweł Recław, AmeN
 * @project warsztat
 * @created 03.12.2022
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mechanik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String kwalifikacje;
    private String specjalizacja;

    @OneToMany(mappedBy = "mechanik")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<SerwisPojazdu> zrealizowaneSerwisy;
}
