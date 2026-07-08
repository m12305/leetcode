package CodeEveryday;

import java.util.Scanner;

public class day_4_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        func(n);
    }
    public static void func(int n){
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==j || j==0){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j] +arr[i-1][j-1];
                }
                System.out.printf("%5d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
