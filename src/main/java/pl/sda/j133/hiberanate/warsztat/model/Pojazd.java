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
public class Pojazd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marka;
    private String model;
    private String vin;
    private String nrRej;

    @OneToMany(mappedBy = "pojazd")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<SerwisPojazdu> serwisy;
}
