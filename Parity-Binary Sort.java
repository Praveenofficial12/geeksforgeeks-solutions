import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String[] parts = br.readLine().split(" ");

            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            Arrays.sort(arr, (a, b) -> {

                int bitA = Integer.bitCount(a);
                int bitB = Integer.bitCount(b);

                boolean evenA = (bitA % 2 == 0);
                boolean evenB = (bitB % 2 == 0);

                if (evenA && !evenB) return -1;
                if (!evenA && evenB) return 1;

                return a - b;
            });

            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
