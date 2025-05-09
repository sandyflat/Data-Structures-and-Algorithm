package HashMap;
import java.util.HashMap;
import java.util.Map;

public class Hashing {
    public static void main(String[] args) {
        // country(key), population(value)
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("Nepal", 100);
        map.put("US", 230);
        map.put("China", 456);
        map.put("India", 234);

        System.out.println(map);       // HashMap is unorderd map.

        map.put("China", 500);         // update the previous value.if exists
        System.out.println(map);

        // Remove
        map.remove("India");

        // Search
        if(map.containsKey("China")){      // search for key.
            System.out.println("Key is present in the map.");
        }else{
            System.out.println("key is not present in the map.");
        }

        if(map.containsValue(100)){         // search for value
            System.out.println(" value is present in the map");
        }else{
            System.out.println(" value is not present in the map");
        }

        System.out.println(map.get("China"));   // gives corresponding value of key.

        // Iteration
        for(Map.Entry<String, Integer> e : map.entrySet()){     // iterate whole map
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
