package hu.flowacademy.kappaspring.firststeps.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // Ugyan az, mintha megirnank magunknak a buildert, csak kevesebb kod
@NoArgsConstructor
@AllArgsConstructor
public class LombokCar {
    private String color;
    private String manufacture;
    private int hp;
    private int tireCount;
    private String type;
    private String fuelKind;
    private int doorCount;
    private boolean electricEngine;
    private boolean cupHolder;
    private int ciliderCount;
}
