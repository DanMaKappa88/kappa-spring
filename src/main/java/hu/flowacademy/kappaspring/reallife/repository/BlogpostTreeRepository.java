package hu.flowacademy.kappaspring.reallife.repository;

import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

//@Primary // Lehetne, de ez kizarja, hogy initaskor valasszak implementaciot az interface-hez
//@Repository
public class BlogpostTreeRepository implements BlogpostRepository {
    private final Map<String, Blogpost> storage = new TreeMap<>();

    @Override
    public List<Blogpost> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Optional<Blogpost> findOne(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Blogpost save(Blogpost blogpost) {
        storage.put(blogpost.getId(), blogpost);
        return blogpost;
    }

    @Override
    public Blogpost update(Blogpost blogpost) {
        Blogpost existingBlogpost = storage.get(blogpost.getId());
        if (existingBlogpost == null) {
            throw new RuntimeException("invalid blogpost id at update " + blogpost.getId());
        }
        storage.put(blogpost.getId(), blogpost);
        return blogpost;
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }
}
