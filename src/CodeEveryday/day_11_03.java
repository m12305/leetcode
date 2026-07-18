package CodeEveryday;

import java.util.Scanner;
import java.util.Stack;

public class day_11_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(func(str));
    }

    public static String func(String str){
        int left = 0;
        Stack<String> stack = new Stack<>();
        StringBuffer res = new StringBuffer();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==' '){
                String temp = str.substring(left,i);
                stack.add(temp);
                left = i+1;
            }
        }
        stack.add(str.substring(left,str.length()));

        while(!stack.isEmpty()){
            res.append(stack.pop());
            res.append(" ");
        }
        return res.toString();
    }
}
