package hu.flowacademy.kappaspring;

import org.springframework.stereotype.Component;

@Component
// azt mondja a Springnek, hogy legyen ebbol
// egy peldany amit majd le tudok kerni barhol
public class Component1 {

    public String getName() {
        return "I'm component 1";
    }

}
