package CodeEveryday;

import java.util.Scanner;

public class day_10_03 {

    // https://www.nowcoder.com/practice/cc1a9bc523a24716a117b438a1dc5706
    //递归解法，时间复杂度会超
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        System.out.println(func(0, 0, n , m, x, y));
    }

    public static int func (int a,int b,int n,int m,int x,int y){
        if(a>n || b>m){return 0;}
        if(isdied(a,b,x,y)){return 0;}
        if(a == n && b ==m){return 1;}
        int m1 = func(a+1,b,n,m,x,y);
        int m2 = func(a,b+1,n,m,x,y);

        return m1+m2;
    }

    public static boolean isdied(int n,int m,int x,int y){
        if(n==x && m == y){return true;}
        int a = Math.abs(n-x);
        int b = Math.abs(m-y);
        if(a+b==3 && n!=x && m!=y){return true;}
        return false;
    }

    //可以使用DP


}
