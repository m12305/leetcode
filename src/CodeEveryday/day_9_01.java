package CodeEveryday;

import java.util.Scanner;
import java.util.Stack;

public class day_9_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(func(n));
    }

    public static String func(long n) {
        Stack<String> stack = new Stack<>();
        StringBuffer res = new StringBuffer();
        while (n > 0) {
            long temp = n % 1000;
            String str;
            if(temp<100  && temp>=10){
                str = ",0"+ temp;
            }else if(temp<10){
                str = ",00"+ temp;
            }else{
                str = ","+ temp;
            }
            stack.add(str);
            n = n / 1000;
        }
        while (! stack.isEmpty()) {
            res.append(stack.pop());
        }
        int i;
        for(i = 0;i<res.length();i++){
            char temp = res.charAt(i);
            if(temp!=',' && temp!='0'){break;}
        }
        return res.substring(i).toString();
    }
}
