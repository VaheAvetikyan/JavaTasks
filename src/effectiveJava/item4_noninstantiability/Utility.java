package effectiveJava.item4_noninstantiability;

public class Utility {
    public static void main(String[] args) {
        UtilityClass.run();
        // UtilityClass u = new UtilityClass();
    }
}

class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void run() {
        System.out.println("Running");
    }
}

/*  The private constructor prevents the class from being subclassed
class SubUtil extends UtilityClass {
}
 */