package hu.flowacademy.kappaspring;

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
