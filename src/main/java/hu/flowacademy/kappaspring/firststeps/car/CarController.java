package hu.flowacademy.kappaspring.firststeps.car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/api/car")
    public LombokCar getCar() {
//        return Car.builder().color("red").hp(55).build();
        return LombokCar.builder().color("red").hp(55).build();
    }
}
