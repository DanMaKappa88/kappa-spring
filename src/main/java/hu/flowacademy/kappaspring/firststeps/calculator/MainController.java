package hu.flowacademy.kappaspring.firststeps.calculator;

import hu.flowacademy.kappaspring.firststeps.calculator.CalculatorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// A @RestController is Spring komponens
@RestController
public class MainController {

    // A @GetMapping után sosem rakunk @RequestBody-t
    @GetMapping("/api/hello-world")
    public String helloWorld() {
        return "Hello world!";
    }

    // @RequestBody-bol mindig csak egy lehet egy paraméterlistában
    @PostMapping("/api/plus")
    public int plus(@RequestBody CalculatorRequest calculatorRequest) {
        return calculatorRequest.getNum1() + calculatorRequest.getNum2();
    }

    // @PathVariable -t jelölni kell a Mapping-ben, {} között
    @DeleteMapping("/api/minus/{num1}/{num2}")
    public int minus(@PathVariable(name = "num1") int first,
                     @PathVariable(name = "num2") int second) {
        return first - second;
    }

    @PutMapping("/api/multiply")
    public int multiply(@RequestParam("num1") int first,
                        @RequestParam("num2") int second) {
        return first * second;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/api/calculator")
    public int calculate(@RequestParam("num1") int first, // Az URL query paramból olvassa ki a num1 értékét
                         @RequestParam("num2") int second, // Az URL query paramból olvassa ki a num2 értékét
                         @RequestHeader("Operation") String operation // A request headerből olvassa ki az Operation értékét
    ) {
        switch (operation) {
            case "plus":
                return first + second;
            case "minus":
                return first - second;
            case "multiply":
                return first * second;
            default:
                throw new RuntimeException("invalid operation " + operation);
        }
    }

}
