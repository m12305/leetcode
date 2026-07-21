package CodeEveryday;

import java.util.Arrays;
import java.util.Scanner;

public class day_14_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n*3];
        for(int i = 0;i<3*n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(func(arr));
    }

    public static long func(int[] arr){
        if(arr.length<3){return 0;}
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        long res = 0;
        while(l<r){
            res+=arr[--r];
            l++;
            r--;
        }
        return res;
    }
}
