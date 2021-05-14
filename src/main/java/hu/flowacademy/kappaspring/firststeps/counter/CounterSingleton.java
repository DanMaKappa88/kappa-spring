package hu.flowacademy.kappaspring.firststeps.counter;

public class CounterSingleton {

    // Amint elindul a program letrejon belole egy peldany
//    private static final CounterSingleton INSTANCE = new CounterSingleton();
    private static CounterSingleton INSTANCE;

    private int i;

    private CounterSingleton() {}

    public static CounterSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CounterSingleton();
        }
        return INSTANCE;
    }

    public int count() {
        return ++i;
    }

    public int getI() {
        return i;
    }
}
