package CodeEveryday;


import java.util.Scanner;

public class day_9_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(func(n));
    }
    public static int func(int n){
        if(n==1){return 1;}
        if(n==2){return 2;}
        int a = func(n-1);
        int b = func(n-2);
        return a+b;
    }
}
