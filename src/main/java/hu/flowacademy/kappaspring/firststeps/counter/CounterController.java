package hu.flowacademy.kappaspring.firststeps.counter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@AllArgsConstructor
@RequiredArgsConstructor
public class CounterController {

    // @Autowired // Nem muszaj kiirni, ha van parameteres konstruktora az osztalynak
    private final Counter counter;

    @GetMapping("/counter")
    public int getCounter() {
        return counter.getI(); // Visszaadja az aktualis allapotat a counternek
    }

    @PostMapping("/counter")
    public int count() {
        return counter.count(); // Visszaadja az eggyel novelt erteket a counternek
    }

//    // Lehet igy is injektalni
//    @Autowired
//    public void setCounter(Counter counter) {
//        this.counter = counter;
//    }

    @GetMapping("/singleton/counter")
    public int getSingletonCounter() {
        return CounterSingleton.getInstance().getI();
    }

    @PostMapping("/singleton/counter")
    public int countSingleton() {
        return CounterSingleton.getInstance().count();
    }
}
