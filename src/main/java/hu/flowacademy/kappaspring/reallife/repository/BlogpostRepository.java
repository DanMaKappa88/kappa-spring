package hu.flowacademy.kappaspring.reallife.repository;

import hu.flowacademy.kappaspring.reallife.model.Blogpost;

import java.util.List;
import java.util.Optional;

public interface BlogpostRepository {

    List<Blogpost> findAll();
    Optional<Blogpost> findOne(String id);
    Blogpost save(Blogpost blogpost);
    Blogpost update(Blogpost blogpost);
    void delete(String id);

}
