package hu.flowacademy.kappaspring.firststeps.car;

public class Car {
    private final String color;
    private final String manufacture;
    private final int hp;
    private final int tireCount;
    private final String type;
    private final String fuelKind;
    private final int doorCount;
    private final boolean electricEngine;
    private final boolean cupHolder;
    private final int ciliderCount;

    private Car(String color, String manufacture, int hp, int tireCount, String type, String fuelKind, int doorCount, boolean electricEngine, boolean cupHolder, int ciliderCount) {
        this.color = color;
        this.manufacture = manufacture;
        this.hp = hp;
        this.tireCount = tireCount;
        this.type = type;
        this.fuelKind = fuelKind;
        this.doorCount = doorCount;
        this.electricEngine = electricEngine;
        this.cupHolder = cupHolder;
        this.ciliderCount = ciliderCount;
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public static class CarBuilder {
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

        CarBuilder() {}

        public Car build() {
            return new Car(color, manufacture, hp, tireCount, type, fuelKind, doorCount, electricEngine, cupHolder, ciliderCount);
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder hp(int hp) {
            this.hp = hp;
            return this;
        }

        public CarBuilder tireCount(int tireCount) {
            this.tireCount = tireCount;
            return this;
        }

        public CarBuilder doorCount(int doorCount) {
            this.doorCount = doorCount;
            return this;
        }

        public CarBuilder ciliderCount(int ciliderCount) {
            this.ciliderCount = ciliderCount;
            return this;
        }

        public CarBuilder manufacture(String manufacture) {
            this.manufacture = manufacture;
            return this;
        }

        public CarBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CarBuilder fuelKind(String fuelKind) {
            this.fuelKind = fuelKind;
            return this;
        }

        public CarBuilder electricEngine(boolean electricEngine) {
            this.electricEngine = electricEngine;
            return this;
        }

        public CarBuilder cupHolder(boolean cupHolder) {
            this.cupHolder = cupHolder;
            return this;
        }
    }

}
