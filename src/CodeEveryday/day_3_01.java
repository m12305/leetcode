package CodeEveryday;

import java.util.Scanner;

public class day_3_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer str = new StringBuffer();
        while(in.hasNext()){
            str.append(Character.toUpperCase(in.next().charAt(0)));
        }
        System.out.println(str);
    }
}
