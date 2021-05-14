package hu.flowacademy.kappaspring.firststeps.counter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Counter {

    private int i;

    public int count() {
        return ++i;
    }

}
