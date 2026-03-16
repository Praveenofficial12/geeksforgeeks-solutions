import java.io.*;
import java.util.*;
class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String village = br.readLine().trim();
        StringBuilder result = new StringBuilder();
        for (char c : village.toCharArray()) {
            if (c == '.') {
                result.append('B');
            } else {
                result.append('H');
            }
        }
        System.out.println("YES");
        System.out.println(result.toString());
    }
}
