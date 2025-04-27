import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 2);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            int target = data[size / 2];

            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();
            long timeLinear = endLinear - startLinear;

            Arrays.sort(data);
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();
            long timeBinary = endBinary - startBinary;

            System.out.printf("Dataset Size: %,d\n", size);
            System.out.printf("Linear Search Time: %.3f ms\n", timeLinear / 1_000_000.0);
            System.out.printf("Binary Search Time: %.3f ms\n", timeBinary / 1_000_000.0);
            System.out.println("-----------------------------");
        }
    }
}
