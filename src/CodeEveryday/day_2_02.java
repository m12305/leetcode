package CodeEveryday;

import java.util.Scanner;

public class day_2_02 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] cost = new int[in.nextInt()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = in.nextInt();
        }
        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        if(cost.length==1){return cost[0];}
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }

}
