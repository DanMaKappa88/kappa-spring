package hu.flowacademy.kappaspring.reallife.config;

import hu.flowacademy.kappaspring.reallife.repository.BlogpostHashRepository;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostRepository;
import hu.flowacademy.kappaspring.reallife.repository.BlogpostTreeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
