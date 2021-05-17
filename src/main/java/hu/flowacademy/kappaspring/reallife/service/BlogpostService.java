package hu.flowacademy.kappaspring.reallife.service;

import hu.flowacademy.kappaspring.reallife.exception.ValidationException;
import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

//    public BlogpostService(@Qualifier("blogpostTreeRepository") BlogpostRepository blogpostRepository) {
//        this.blogpostRepository = blogpostRepository;
//    }

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
        validate(blogpost);
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
        validate(blogpost.toBuilder().id(id).build());
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

    void validate(Blogpost blogpost) {
        if (blogpost.getId() != null) {
            try {
                UUID.fromString(blogpost.getId());
            } catch (IllegalArgumentException e) {
                throw new ValidationException("id should be in UUID format");
            }
        }
        if (!StringUtils.hasText(blogpost.getTitle())) {
            throw new ValidationException("title should be present");
        }
        if (!StringUtils.hasText(blogpost.getDescription())) {
            throw new ValidationException("description should be present");
        }
        if (!StringUtils.hasText(blogpost.getPublisher())) {
            throw new ValidationException("publisher's name should be present");
        }
    }
}
