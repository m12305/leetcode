package CodeEveryday;

import java.util.Scanner;

public class day_13_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0;i<n;i++){
            int num = in.nextInt();
            int k = in.nextInt();
            String str = in.next();
            System.out.println(func(str,k));
        }
    }

    public static int func(String str,int k){
        char[] arr = str.toCharArray();
        int res = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]=='W'){
                count++;
                if(count>=3){res+=k;}
                else{res++;}
            }else{
                count = 0;
                res--;
            }
        }
        return res;
    }

}
