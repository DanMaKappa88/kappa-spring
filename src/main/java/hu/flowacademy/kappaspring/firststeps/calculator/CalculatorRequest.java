package hu.flowacademy.kappaspring.firststeps.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gettereket, settereket, toString, hashCode, equals general
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorRequest {
    private int num1;
    private int num2;
}
