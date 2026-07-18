package CodeEveryday;

import java.util.Scanner;

public class day_11_01 {

    //贪心，过不了
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(func(n,m,a,b));
    }

    public static int func(int n, int m, int a, int b) {
        int res = 0;
        if(n<2 && m<2){return 0;}
        if(n==0 || m==0){return 0;}
        if (a > b) {
            int num1 = Math.min(n / 2, m);
            int num2 = Math.min((m - num1) / 2, n - num1 * 2);
            return a * num1 + b * num2;
        } else {
            int num2 = Math.min(m / 2, n);
            int num1 = Math.min((n - num2) / 2, m - num2 * 2);
            return a * num1 + b * num2;
        }
    }

    //枚举每个礼包可能的情况，求最大值
}
