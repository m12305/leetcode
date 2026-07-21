package CodeEveryday;

import java.util.HashMap;
import java.util.Scanner;

public class day_14_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        System.out.println(func(arr1,arr2));
    }

    public static String func(char[] arr1,char[] arr2){

        HashMap<Character,Integer> map = new HashMap<>();
        for(char x :arr1){
            int temp = map.getOrDefault(x,0);
            map.put(x,temp+1);
        }
        for(char x:arr2){
            if(!map.containsKey(x)){
                return "No";
            }
            int temp = map.get(x);
            if(temp>0){map.put(x,temp-1);}
            else{return "No";}
        }
        return "Yes";
    }
}
