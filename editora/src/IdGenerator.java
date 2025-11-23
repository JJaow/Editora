import java.util.HashMap;
import java.util.Map;

public final class IdGenerator {
    private static final Map<String, Integer> counters = new HashMap<>();

    private IdGenerator() {}

    public static synchronized int nextId(String key) {
        Integer v = counters.get(key);
        if (v == null) v = 0;
        v = v + 1;
        counters.put(key, v);
        return v;
    }
}
