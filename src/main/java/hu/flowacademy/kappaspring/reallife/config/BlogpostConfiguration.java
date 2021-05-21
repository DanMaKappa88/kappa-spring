package hu.flowacademy.kappaspring.reallife.config;

import com.github.javafaker.Faker;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostHashRepository;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostRepository;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostTreeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Slf4j
@Configuration
public class BlogpostConfiguration {

    @Value("${blogpost.type}")
    private String blogpostType;

    @Bean
    public BlogpostRepository blogpostRepository() {
        log.info("Blogpost repository type is: {}", blogpostType);
        if ("hash".equals(blogpostType)) {
            return new BlogpostHashRepository();
        } else if ("tree".equals(blogpostType)) {
            return new BlogpostTreeRepository();
        }
        throw new BeanCreationException("invalid blogpost type [should be hash or tree]: " + blogpostType);
    }

    @Bean
    public Faker faker() {
        return new Faker(Locale.forLanguageTag("hu-HU"));
    }

}
