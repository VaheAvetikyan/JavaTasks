package effectiveJava.item3_singleton;

// Singleton with public final field
public class Connection {
    public static final Connection INSTANCE = new Connection();

    private Connection() {
    }

    public boolean connected() {
        return true;
    }
}

// Singleton with static factory
class Connect {
    private static final Connect INSTANCE = new Connect();

    private Connect() {
    }

    public static Connect getInstance() {
        return INSTANCE;
    }

    public boolean connected() {
        return true;
    }
}

// Enum singleton - the preferred approach
enum ConnectionEnum {
    INSTANCE;

    public boolean connected() {
        return true;
    }
}