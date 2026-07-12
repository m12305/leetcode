package CodeEveryday;

import java.util.Scanner;

public class day_8_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        for(int i = 1;i<=Math.min(a,b);i++){
            if((b*i)%a ==0 ){
                System.out.println(b*i);
                break;
            }
        }
    }
}
