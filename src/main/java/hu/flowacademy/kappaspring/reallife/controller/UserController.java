package hu.flowacademy.kappaspring.reallife.controller;

import hu.flowacademy.kappaspring.reallife.model.User;
import hu.flowacademy.kappaspring.reallife.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findOne(@PathVariable String id) {
        return userService.findOne(id);
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/users/current")
    public User getCurrentUser(Authentication authentication) {
//        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (User) authentication.getPrincipal();
    }

}
