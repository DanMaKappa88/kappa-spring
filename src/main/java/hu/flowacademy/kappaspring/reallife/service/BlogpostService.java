package hu.flowacademy.kappaspring.reallife.service;

import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Ellátjuk az osztályt @Service-szel, hogy a Spring Application Context-hez tartozzon
// Így injektálni tud, és injektálhatóvá vállik (komponens lesz)
@Service
// Szükséges a konstruktoron keresztüli injektáláshoz
@RequiredArgsConstructor
public class BlogpostService {
    // Beinjektáljuk a repository-t, hogy tudjunk adatbázis (vagy olyasmi) műveleteket végezni
    private final BlogpostRepository blogpostRepository;

    // Tovább hív a repository-ra, ami ténylegesen tárolja az adatokat
    public List<Blogpost> findAll() {
        return blogpostRepository.findAll();
    }

    // Tovább hív a repository-ra, ami ténylegesen tárolja az adatokat
    public Optional<Blogpost> findOne(String id) {
        return blogpostRepository.findOne(id);
    }

    // Tovább hív a repository-ra, ami ténylegesen tárolja az adatokat
    // de előtte lemásolja (toBuilder) és beállítja a szükséges mezőit a requestnek
    // úgy mint, id, createdAt
    public Blogpost save(Blogpost blogpost) {
//        blogpost.setId(UUID.randomUUID().toString());
        return blogpostRepository.save(blogpost.toBuilder()
                .id(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .build()
        );
    }

    // Tovább hív a repository-ra, ami ténylegesen tárolja az adatokat
    // de előtte lemásolja (toBuilder) és beállítja a szükséges mezőit a requestnek
    // úgy mint, updatedAt
    public Blogpost update(String id, Blogpost blogpost) {
        UUID.fromString(id);
        return blogpostRepository.update(
                blogpost.toBuilder()
                .id(id)
                .updatedAt(LocalDateTime.now())
                .build()
        );
    }

    // Tovább hív a repository-ra, ami ténylegesen tárolja az adatokat
    public void delete(String id) {
        blogpostRepository.delete(id);
    }
}
