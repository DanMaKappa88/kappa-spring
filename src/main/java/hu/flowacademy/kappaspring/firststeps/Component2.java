package hu.flowacademy.kappaspring.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Az app indulásakor létrehoz egy példányt a Component2-ből
// ez később bármikor/bárhol lekérhető
@Component
public class Component2 {

    // A Component2 beinjektálja a Component1 egy példányát
    @Autowired
    private Component1 component1;

    public String getOtherOneName() {
        return "Component1 name is: " + component1.getName();
    }

    public String getName() {
        return "I'm component 2";
    }

}
