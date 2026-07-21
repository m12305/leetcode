package CodeEveryday;

import java.util.Scanner;

public class day_14_03 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = reader.nextInt();
        }
        int[] dp = new int[10001];
        int[] trans = new int[10001];
        for (int i = 0; i < p.length; i++) {
            trans[p[i]] += p[i];
        }
        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + trans[i]);
        }
        System.out.println(dp[dp.length - 1]);
    }
}
