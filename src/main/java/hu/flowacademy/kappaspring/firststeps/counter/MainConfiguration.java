package hu.flowacademy.kappaspring.firststeps.counter;

import hu.flowacademy.kappaspring.firststeps.counter.Counter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    // Map<String,Object> beans = new HashMap<>();
    // beans.put("createCounter", createCounter());
    // Amikor @Autowired-ot hivsz, akkor a Spring megnezi, hogy az a tipus amit te le akarsz kerni
    // benne van-e ebbe a map-ben. Ha igen, akkor visszaadja, ha nem akkor null.
    // A Bean olyan, mint az osztaly, egy absztrakt definicio, nem egy "megfoghato" dolog
    @Bean
    public Counter createCounter() {
        return new Counter(10);
    }

}
