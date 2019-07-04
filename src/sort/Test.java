package sort;

import java.util.*;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("a",1);
        linkedHashMap.put("b",2);
        linkedHashMap.put("c",3);
        linkedHashMap.put("d",4);

        linkedHashMap.get("b");

        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        for (Map.Entry<String,Integer> entry : entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println();

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("a",1);
        hashMap.put("b",3);
        hashMap.put("c",2);
        hashMap.put("d",4);

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<String,Integer> entry : entrySet){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
