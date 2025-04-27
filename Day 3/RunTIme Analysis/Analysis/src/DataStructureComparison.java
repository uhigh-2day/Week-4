import java.util.*;

public class DataStructureComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {
            System.out.printf("Dataset Size: %,d\n", size);

            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }

            long startArray = System.nanoTime();
            for (int i = 0; i < size; i++) {
                int x = array[i];
            }
            long endArray = System.nanoTime();
            System.out.printf("Array Search Time: %.3f ms\n", (endArray - startArray) / 1_000_000.0);

            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                hashSet.add(i);
            }

            long startHashSet = System.nanoTime();
            hashSet.contains(size / 2);
            long endHashSet = System.nanoTime();
            System.out.printf("HashSet Search Time: %.3f ms\n", (endHashSet - startHashSet) / 1_000_000.0);

            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < size; i++) {
                treeSet.add(i);
            }

            long startTreeSet = System.nanoTime();
            treeSet.contains(size / 2);
            long endTreeSet = System.nanoTime();
            System.out.printf("TreeSet Search Time: %.3f ms\n", (endTreeSet - startTreeSet) / 1_000_000.0);

            System.out.println("-----------------------------");
        }
    }
}
