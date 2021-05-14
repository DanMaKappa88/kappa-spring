package hu.flowacademy.kappaspring.reallife.repository;

import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Ellátjuk az osztályt @Repository-val, hogy a Spring Application Context-hez tartozzon
// Így injektálni tud, és injektálhatóvá vállik (komponens lesz)
@Repository
public class BlogpostRepository {
    private final Map<String, Blogpost> storage = new HashMap<>();

    // Visszaadja a storage map értékeit egy listában
    public List<Blogpost> findAll() {
        // Minta a fapados list építésre
//        List<Blogpost> result = new ArrayList<>();
//        for(Map.Entry<String, Blogpost> e: storage.entrySet()) {
//            result.add(e.getValue());
//        }
//        return result;
        return List.copyOf(storage.values());
    }

    // Visszaadja a storage map értékeit egy listában
    public Optional<Blogpost> findOne(String id) {
        // Minta a fapados Optional létrehozásra
//        Blogpost blogpost = storage.get(id);
//        if (blogpost == null) {
//            return Optional.empty();
//        }
        // Visszaadja a kért kulcshoz tartozó blogpostot, ha nincs akkor null
        // Amennyiben null, az Optional Empty értéket fog felvenni (elkerülhető vele a null pointer exception)
        return Optional.ofNullable(storage.get(id));
    }

    // Lementi a blogpostot
    public Blogpost save(Blogpost blogpost) {
        storage.put(blogpost.getId(), blogpost);
        return blogpost;
    }

    // Ha nincs az adott id-val blogpost, akkor kivételt dob
    // Különben felülírja a meglévőt
    public Blogpost update(Blogpost blogpost) {
        Blogpost existingBlogpost = storage.get(blogpost.getId());
        if (existingBlogpost == null) {
            throw new RuntimeException("invalid blogpost id at update " + blogpost.getId());
        }
        storage.put(blogpost.getId(), blogpost);
        return blogpost;
    }

    // Törli a blogpostot key alapján
    public void delete(String id) {
        storage.remove(id);
    }
}
