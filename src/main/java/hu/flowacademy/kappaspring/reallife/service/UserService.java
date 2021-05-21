package hu.flowacademy.kappaspring.reallife.service;

import hu.flowacademy.kappaspring.reallife.model.User;
import hu.flowacademy.kappaspring.reallife.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(String id) {
        return userRepository.findById(id);
    }

    public User update(String id, User user) {
        return userRepository.save(user.toBuilder().id(id).build());
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
