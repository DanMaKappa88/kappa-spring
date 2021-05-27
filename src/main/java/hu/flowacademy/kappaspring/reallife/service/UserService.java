package hu.flowacademy.kappaspring.reallife.service;

import hu.flowacademy.kappaspring.reallife.model.Role;
import hu.flowacademy.kappaspring.reallife.model.User;
import hu.flowacademy.kappaspring.reallife.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(String id) {
        return userRepository.findById(id);
    }

    public User update(String id, User user) {
        User oldUser = findOne(id).orElseThrow();
        if (StringUtils.hasText(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(oldUser.getPassword());
        }
        return userRepository.save(user.toBuilder().role(Role.ROLE_USER).id(id).build());
    }

    public User save(User user) {
        return userRepository.save(user.toBuilder()
                .password(passwordEncoder.encode(user.getPassword()))
                .build());
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
