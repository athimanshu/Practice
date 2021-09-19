package random;

import java.util.HashMap;
import java.util.Map;

public class ImmutabilityTest {


}
final class Immutable1 {

    private final int a;
    private final String s;
    private final Map<String, String> metadata;

    public int getA() {
        return a;
    }

    public String getS() {
        return s;
    }
    Immutable1(int a, String s, Map<String, String> metadata){
        this.a = a;
        this.s = s;
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap;
    }
    final void method() {
        System.out.println("This is final method");
    }
}