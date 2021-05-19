package hu.flowacademy.kappaspring.reallife.repository;

import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// JpaRepository generikusai: az első mindig az entitás típusa(ez reprezentálja a táblát)
// A második pedig az entitás @Id-jának a típusát kell, hogy tartalmazza
public interface BlogpostJpaRepository extends JpaRepository<Blogpost, String> {

    // Method based query: a függvény nevét alakítja át a JPA SQL lekérdezéssé
    List<Blogpost> findByTitleContainingOrDescriptionContaining(String title, String description);

    // Ide pedig egy HQL lekérdezést írunk
//    @Query("select b from Blogpost b where b.title LIKE %?#{escape([0])} escape ?#{escapeCharacter()} OR b.description LIKE %?#{escape([0])} escape ?#{escapeCharacter()}")
//    List<Blogpost> findByTitleOrDescriptionLike(String query);

    // Optional<Blogpost> findFirst, findLast

}
