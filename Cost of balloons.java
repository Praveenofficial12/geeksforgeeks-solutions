import java.io.*;
import java.util.*;
class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] costs = br.readLine().split(" ");
            int cg = Integer.parseInt(costs[0]);
            int cp = Integer.parseInt(costs[1]);
            int n = Integer.parseInt(br.readLine().trim());
            int p1 = 0, p2 = 0;
            for (int i = 0; i < n; i++) {
                String[] arr = br.readLine().split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                if (a == 1) p1++;
                if (b == 1) p2++;
            }
            int cost1 = p1 * cg + p2 * cp;
            int cost2 = p1 * cp + p2 * cg;
            System.out.println(Math.min(cost1, cost2));
        }
    }
}
