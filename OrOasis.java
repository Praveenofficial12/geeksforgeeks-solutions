import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String[] parts = br.readLine().split(" ");
            int[] arr = new int[n];

            int totalOR = 0;
            int[] totalBits = new int[32];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(parts[i]);
                totalOR |= arr[i];

                for (int b = 0; b < 32; b++) {
                    if ((arr[i] & (1 << b)) != 0) {
                        totalBits[b]++;
                    }
                }
            }

            int[] windowBits = new int[32];
            int left = 0;
            int currentOR = 0;

            int minLen = Integer.MAX_VALUE;
            int count = 0;

            for (int right = 0; right < n; right++) {

                for (int b = 0; b < 32; b++) {
                    if ((arr[right] & (1 << b)) != 0) {
                        windowBits[b]++;
                        currentOR |= (1 << b);
                    }
                }

                while (left <= right) {

                    if (currentOR != totalOR) break;

                    boolean outsideValid = true;

                    for (int b = 0; b < 32; b++) {
                        if ((totalOR & (1 << b)) != 0) {
                            if (windowBits[b] == totalBits[b]) {
                                outsideValid = false;
                                break;
                            }
                        }
                    }

                    if (!outsideValid) break;

                    int len = right - left + 1;

                    if (len < minLen) {
                        minLen = len;
                        count = 1;
                    } else if (len == minLen) {
                        count++;
                    }

                    for (int b = 0; b < 32; b++) {
                        if ((arr[left] & (1 << b)) != 0) {
                            windowBits[b]--;
                            if (windowBits[b] == 0) {
                                currentOR &= ~(1 << b);
                            }
                        }
                    }

                    left++;
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + count);
            }
        }
    }
}
