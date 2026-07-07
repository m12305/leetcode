package CodeEveryday;

import java.util.Scanner;

public class day_2_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float m = in.nextFloat();
        char x = in.next().charAt(0);
        System.out.println(func(m,x));
    }

    public static int func(float m, char x){
        int res = 0;
        if(x=='y'){res+=5;}

        if(m<1){return res+20;}

        return res+20+ (int)Math.ceil((m-1)/1);

    }
}
