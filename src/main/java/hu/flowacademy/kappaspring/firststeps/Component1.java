package hu.flowacademy.kappaspring.firststeps;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// azt mondja a Springnek, hogy legyen ebbol
// egy peldany amit majd le tudok kerni barhol
@Component
public class Component1 {

    public String getName() {
        return "I'm component 1";
    }

}
