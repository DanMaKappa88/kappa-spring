package hu.flowacademy.kappaspring.reallife.controller;

import hu.flowacademy.kappaspring.reallife.exception.ValidationException;
import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import hu.flowacademy.kappaspring.reallife.service.BlogpostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BlogpostController {
    // Beinjektáljuk a service-t, úgyis ez fogja végezni a munka oroszlán részét
    private final BlogpostService blogpostService;

    // Visszaad minden már felvett blogpostot
    @GetMapping("/blogposts")
    public List<Blogpost> findAll(@RequestParam(name = "searchQuery", required = false) Optional<String> searchQuery) {
        return blogpostService.findAll(searchQuery);
    }

    // Visszaad egy konkrét blogpostot id alapján (path variable-ként küldve)
    @GetMapping("/blogposts/{id}")
    public Optional<Blogpost> findOne(@PathVariable String id) {
        return blogpostService.findOne(id);
    }

    // Létrehoz egy új blogpostot a request body alapján és visszaadja az új példányt, ID-val, createdAt-tel
    @PostMapping("/blogposts")
    @ResponseStatus(HttpStatus.CREATED)
    public Blogpost create(@RequestBody Blogpost blogpost) {
        return blogpostService.save(blogpost);
    }

    // Felülír egy meglévő blogpostot a request body alapján és visszaadja az új példányt, updatedAt-tel beállítva
    @PutMapping("/blogposts/{id}")
    public Blogpost edit(@PathVariable String id,
                         @RequestBody Blogpost blogpost) {
        return blogpostService.update(id, blogpost);
    }

    // Töröl egy blogpost példányt ID alapján
    @DeleteMapping("/blogposts/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        blogpostService.delete(id);
        return ResponseEntity.accepted().build();
    }

}
