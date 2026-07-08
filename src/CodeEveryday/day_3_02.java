package CodeEveryday;

import java.util.Scanner;

public class day_3_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[in.nextInt()];
        int x = in.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int[] res = func(arr, x);
        System.out.println(res[0]+" "+res[1]);
    }

    public static int[] func1(int[] arr, int x){
        int[] res = new int[]{-1,-1};
        int l = 0;
        int r = 0;
        int sum = 0;

        while(r<arr.length){
            while(sum<x && r<arr.length){
                sum+=arr[r];
                r++;
            }
            while(sum>=x && l<=r){
                sum-=arr[l];
                l++;
            }
            if((r-l)<=(res[1]-res[0]) || (res[0]==-1&&res[1]==-1)){
                res[0] = l-1;
                res[1] = r-1;
            }
        }
        return res;
    }

    public static int[] func(int[] arr, int x){
        int[] res = new int[]{-1,-1};
        int l = 0;
        int r = 0;
        int sum = 0;

        while(r<arr.length){
            sum+=arr[r];

            while(sum>=x){
                sum-=arr[l];
                l++;
            }
            if((r-l+1)<=(res[1]-res[0]) || (res[0]==-1&&res[1]==-1)){
                res[0] = l-1;
                res[1] = r;
            }
            r++;
        }
        return res;
    }

}
