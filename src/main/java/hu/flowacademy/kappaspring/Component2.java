package hu.flowacademy.kappaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Az app indulásakor létrehoz egy példányt a Component2-ből
// ez később bármikor/bárhol lekérhető
public class Component2 {

    @Autowired
    // A Component2 beinjektálja a Component1 egy példányát
    private Component1 component1;

    public String getOtherOneName() {
        return "Component1 name is: " + component1.getName();
    }

    public String getName() {
        return "I'm component 2";
    }

}
