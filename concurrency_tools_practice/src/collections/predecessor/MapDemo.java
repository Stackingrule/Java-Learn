package collections.predecessor;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.isEmpty());
        map.put("东哥", 38);
        map.put("西哥", 48);
        System.out.println(map.keySet());
        System.out.println(map.get("东哥"));
        System.out.println(map.size());
        System.out.println(map.containsKey("西哥"));
        System.out.println(map.containsValue(48));

    }
}
