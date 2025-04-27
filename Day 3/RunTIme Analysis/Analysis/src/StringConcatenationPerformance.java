public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.printf("Operations Count: %,d\n", size);

            long startString = System.nanoTime();
            String s = "";
            for (int i = 0; i < size; i++) {
                s += "a";
            }
            long endString = System.nanoTime();
            System.out.printf("String Time: %.3f ms\n", (endString - startString) / 1_000_000.0);

            long startBuilder = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append("a");
            }
            long endBuilder = System.nanoTime();
            System.out.printf("StringBuilder Time: %.3f ms\n", (endBuilder - startBuilder) / 1_000_000.0);

            long startBuffer = System.nanoTime();
            StringBuffer sbuf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbuf.append("a");
            }
            long endBuffer = System.nanoTime();
            System.out.printf("StringBuffer Time: %.3f ms\n", (endBuffer - startBuffer) / 1_000_000.0);

            System.out.println("-----------------------------");
        }
    }
}
