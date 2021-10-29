package effectiveJava.item3_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTester {
    public static void main(String[] args) {
        Connection connectionInstance1 = Connection.INSTANCE;
        System.out.println(connectionInstance1);
        Connection connectionInstance2 = Connection.INSTANCE;
        System.out.println(connectionInstance2);

        // Singleton Violation by reflection
        try {
            Constructor<Connection> constructor = Connection.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Connection connectionInstance3 = constructor.newInstance();
            System.out.println(connectionInstance3);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
