package CodeEveryday;

import java.util.Scanner;

//day_4_01: https://www.nowcoder.com/practice/18ecd0ecf5ef4fe9ba3f17f8d00d2d66?tpId=122&tqId=33668&ru=/exam/oj

public class day_4_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();

        System.out.println(func(m));

    }

    public static int func(int m){
        int l = 0;
        int r = 1;
        int tar = 0;

        while(tar<m){
            tar = l+r;
            l = r;
            r = tar;
        }

        return Math.min((tar-m),(m-l));
    }
}
