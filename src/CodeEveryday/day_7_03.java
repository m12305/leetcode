package CodeEveryday;

import java.util.ArrayList;
import java.util.Scanner;

public class day_7_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][6];

        while (in.hasNext()) {
            for (int i = 0 ; i < n; i++) {
                for (int j = 0; j < 6; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
        }

        for (int i = 0 ; i < n; i++) {
            func(arr[i]);
        }
    }

    public static void func(int[] arr) {
        int a, b, c;

        for (int i = 0; i < arr.length - 2; i++) {
            a = i;
            for (int j = i + 1; j < arr.length -1 ; j++) {
                b = j;
                for (int k = j + 1; k < arr.length; k++) {
                    c = k;
                    if(isTri(arr[a],arr[b],arr[c])){
                        if (func(a, b, c, arr)) {
                            System.out.println("Yes");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("No");
    }

    public static boolean func(int a, int b, int c, int[] arr) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (i != a && i != b && i != c) {
                temp.add(arr[i]);
            }
        }
        return isTri(temp.get(0), temp.get(1), temp.get(2));
    }

    public static boolean isTri(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }
}
