package hejow.java.practice.etc.hash;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        map.put(null, new Object());
        map.put(new Object(), null);

        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put(null, null);
        hashtable.put(null, new Object());
        hashtable.put(new Object(), null);

        Set set = new TreeSet();
    }
}
