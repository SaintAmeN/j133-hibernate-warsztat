package pl.sda.j133.hiberanate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
public class SerwisPojazdu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opis;

    @CreationTimestamp
    private LocalDateTime czasDodania;

    // TODO: dokończyć komendę która "zamyka" zlecenie serwisowe SerwisPojazdu
    // KomendaZrealizujSerwisPojazdu
    // KomendaZamknijSerwisPojazdu
    private LocalDateTime czasZrealizowania;
    private String zrealizowaneCzynnosci;
    private Double koszt;

    @ManyToOne
    @ToString.Exclude
    private Mechanik mechanik;

    @ManyToOne
    @ToString.Exclude
    private Pojazd pojazd;
}
