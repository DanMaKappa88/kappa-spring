package hu.flowacademy.kappaspring.reallife.bootstrap;

import com.github.javafaker.Faker;
import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class InitDataLoader implements CommandLineRunner {

    private final BlogpostJpaRepository blogpostJpaRepository;
    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {
        List<Blogpost> blogposts = blogpostJpaRepository.saveAll(
                IntStream.range(0, 10)
                        .mapToObj(value -> Blogpost.builder()
                                .id(UUID.randomUUID().toString())
                                .title(faker.book().title())
                                .description(faker.chuckNorris().fact())
                                .createdAt(LocalDateTime.now())
                                .publisher(faker.starTrek().character())
                                .build())
                        .collect(Collectors.toList())
        );

        log.info("Generated {} blogposts", blogposts.size());
    }
}
