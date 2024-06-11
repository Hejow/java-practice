package hejow.java.practice.etc.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionExample {
    public static void main(String[] args) {
//        Collections.singletonMap(키, 값);
//        Collections.unmodifiableList(리스트);
//        Collections.sort(컬렉션 객체);
//        Collections.reverse(리스트);
        List<Object> list = new LinkedList<>();
        list.add(null);

        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, "value");
        Map<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(null, "vaue"); // NPE
        Map<Object, Object> linkedHashMap = new LinkedHashMap<>(3, 0.75F, true);

        for (int i = 0; i < 3; i++) {
            linkedHashMap.put("key" + i, "value" + i);
        }

        linkedHashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        linkedHashMap.get("key1");
        System.out.println();
        linkedHashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));

        Set<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        Set<Object> treeSet = new TreeSet<>();
        treeSet.add(null); // NPE
        Set<Object> hashSet = new HashSet<>();
        hashSet.add(null);
    }
}
