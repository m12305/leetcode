package CodeEveryday;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day_12_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(func(str1,str2));
    }

    public static String func(String str1 ,String str2){
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char x :arr2){
            set.add(x);
        }
        StringBuffer res = new StringBuffer();
        for(char x:arr1){
            if(!set.contains(x)){
                res.append(x);
            }
        }
        return res.toString();
    }
}
