import java.util.LinkedList;

public class RunLinkedList {
    private static void endTime(double start, String funcName) {
        System.out.printf("%s %.0f %s", funcName, (System.currentTimeMillis() - start), "\n\n");
    }

    public static void main(String[] args) {
        GarriksLinkedList<String, Integer> garriksList = new GarriksLinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        double start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            garriksList.add(i);
        }
        endTime(start, "garriksList.add ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        endTime(start, "linkedList.add ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            garriksList.getHead();
        }
        endTime(start, "garriksList.getHead ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.getFirst();
        }
        endTime(start, "linkedList.getFirst ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            garriksList.size();
        }
        endTime(start, "garriksList.size ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.size();
        }
        endTime(start, "linkedList.size ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            garriksList.isEmpty();
        }
        endTime(start, "garriksList.isEmpty ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.isEmpty();
        }
        endTime(start, "linkedList.isEmpty ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            garriksList.contains(i);
        }
        endTime(start, "garriksList.contains ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.contains(i);
        }
        endTime(start, "linkedList.contains ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            garriksList.get(i);
        }
        endTime(start, "garriksList.get ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
        endTime(start, "linkedList.get ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            garriksList.indexOf(i);
        }
        endTime(start, "garriksList.indexOf ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.indexOf(i);
        }
        endTime(start, "linkedList.indexOf ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            garriksList.set(i, i);
        }
        endTime(start, "garriksList.set ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.set(i, i);
        }
        endTime(start, "linkedList.set ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            garriksList.remove(i);
        }
        endTime(start, "garriksList.remove ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(i);
        }
        endTime(start, "linkedList.remove ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            garriksList.clear();
        }
        endTime(start, "garriksList.clear ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.clear();
        }
        endTime(start, "linkedList.clear ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            garriksList.add(i, i);
        }
        endTime(start, "garriksList.add ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i, i);
        }
        endTime(start, "linkedList.add ");
    }

}

