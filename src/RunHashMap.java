import java.util.HashMap;
import java.util.LinkedList;

public class RunHashMap {
    private static void endTime(double start, String funcName) {
        System.out.printf("%s %.0f %s", funcName, (System.currentTimeMillis() - start), "\n\n");
    }

    public static void main(String[] args) {
        GarriksHashMap<String, Integer> garriksMap = new GarriksHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        double start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            garriksMap.put(String.format("sus%d", i), i);
        }
        endTime(start, "garriksMap.put ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashMap.put(String.format("sus%d", i), i);
        }
        endTime(start, "hashMap.put ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            garriksMap.size();
        }
        endTime(start, "garriksMap.size ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hashMap.size();
        }
        endTime(start, "hashMap.size ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            garriksMap.isEmpty();
        }
        endTime(start, "garriksMap.isEmpty ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hashMap.isEmpty();
        }
        endTime(start, "hashMap.isEmpty ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            garriksMap.containsKey(String.format("sus%d", i));
        }
        endTime(start, "garriksMap.containsKey ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashMap.containsKey(String.format("sus%d", i));
        }
        endTime(start, "hashMap.containsKey ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            garriksMap.containsValue(i);
        }
        endTime(start, "garriksMap.containsValue ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashMap.containsValue(i);
        }
        endTime(start, "hashMap.containsValue ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            garriksMap.get(String.format("sus%d", i));
        }
        endTime(start, "garriksMap.get ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            hashMap.get(String.format("sus%d", i));
        }
        endTime(start, "hashMap.get ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            garriksMap.remove(String.format("sus%d", i));
        }
        endTime(start, "garriksMap.remove ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashMap.remove(String.format("sus%d", i));
        }
        endTime(start, "hashMap.remove ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            garriksMap.clear();
        }
        endTime(start, "garriksMap.clear ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            hashMap.clear();
        }
        endTime(start, "hashMap.clear ");
    }
}
