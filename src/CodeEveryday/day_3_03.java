package CodeEveryday;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class day_3_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[in.nextInt()];
        int k = in.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(func(arr, k));
    }

    public static long func(int[] arr, int k) {
        long res = 0;
        PriorityQueue<Integer> queue  = new PriorityQueue<Integer>
                (new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

        for (int temp : arr) {
            if (temp % 2 == 0) {
                queue.add(temp);
            } else {
                res += temp;
            }
        }
        while (k > 0 && !queue.isEmpty()) {
            int m = queue.poll();
            m = m / 2;
            if (m % 2 == 0) {
                queue.add(m);
            } else {
                res += m;
            }
            k--;
        }
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }
}
