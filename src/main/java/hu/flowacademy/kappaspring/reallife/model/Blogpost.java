package hu.flowacademy.kappaspring.reallife.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Mindig olyan dologra rakjuk, amibol 1 van!!!
    // (cascade = CascadeType.ALL) arra kell, ha nem csak összekapcsolni szeretnénk meglévő felhsználókat blogpostokkal
    // hanem amennyiben még nem létezik a felhasználó, akkor létrehozza
    @ManyToOne
    @JoinColumn(nullable = false)
    private User publisher;

    @Version
    private int version;

//    @OneToOne
//    @JoinColumn(nullable = false)
//    private User publisher;

//    @ManyToMany
//    @JoinTable(name = "blogpost_owners",
//            joinColumns = @JoinColumn(name = "blogpost_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> owners;

//    @OneToMany(mappedBy = "blogpost")
//    private List<BlogpostOwners> blogpostOwners;

}
