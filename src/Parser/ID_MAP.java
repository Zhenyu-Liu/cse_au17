package Parser;

import java.util.HashMap;
import java.util.Map;

public class ID_MAP {
    private Map<String, Integer> map;

    public ID_MAP() {
        map = new HashMap<String, Integer>();
    }

    public boolean insert(String key) {
        if (map.containsKey(key)) {
            System.out.println("ERROR: Invalid/Duplicate ID name");
            System.exit(7);
        }
        map.put(key, 0);
        return true;
    }

//    public boolean insert(String key, int val) {
//        if (map.containsKey(key)) return false;
//        map.put(key, val);
//        return true;
//    }

    public int get(String key) {
        if (!map.containsKey(key)) {
            System.out.println("ERROR: ID not exist");
            System.exit(7);
        }
        return map.get(key);
    }

    public boolean assign(String key, int val) {
        if (!map.containsKey(key)) {
            System.out.println("ERROR: ID does not exist");
            System.exit(7);
        }
        map.put(key, val);
        return true;
    }
}
