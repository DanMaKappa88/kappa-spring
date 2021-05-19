package hu.flowacademy.kappaspring.reallife.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
// Kötelező adatbázis kapcsolatnál,
// ez jelzi, hogy egy adatbázis táblát reprezentál az osztály
@Entity
@Table(name = "blogposts")
@Builder(toBuilder = true) // toBuilder egy copy metodus lesz
@NoArgsConstructor
@AllArgsConstructor
public class Blogpost {
    @Id // Kötelező, ha kint van az @Entity az osztályon
//    @GeneratedValue(generator = "uuid2")
    private String id;
    @Column(nullable = false)
    private String title;
    private String description;
    // opcionalis annotáció, akkor használjuk,
    // ha valami egyedi dolgot akarunk az oszlopon meghatározni
    @Column(nullable = false)
    private String publisher;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
