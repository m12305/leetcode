package CodeEveryday;

import java.util.HashSet;
import java.util.Scanner;
// https://ac.nowcoder.com/acm/contest/63091/A
public class day_5_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] arr = new char[n][m];
        for(int i = 0;i<n;i++){
            String str = in.nextLine();
            for(int j = 0;j<m;j++){
                arr[i][j]=str.charAt(j);
            }
        }

        char[] mm = new char[]{'y','o','u'};
        int num = 2;

        System.out.println(func(arr, mm, num-1));

    }


    public static int func(char[][] arr,char[] mm, int num){

        int res = 0;
        int x = 0;
        int y = 0;

        while ((x+num)<= arr.length){
            while ((y+num)<= arr[0].length){
                HashSet<Character> temp = new HashSet<>();
                for (char t:mm){
                    temp.add(t);
                }
                for (int i = x; i < x+num; i++) {
                    for (int j = y; j < y+num; j++) {
                        temp.remove(arr[i][j]);
                    }
                }
                if (temp.isEmpty()){res++;}
                y++;
            }
            x++;
        }
        return res;
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        int[][] arr = new int[q][3];
        for(int i = 0;i<q;i++){
            for(int j = 0;j<3;j++){
                arr[i][j] = in.nextInt();
            }
        }

        func(arr);
    }

    public static void func(int[][] arr){
        int x,y,z;
        for(int i = 0;i<arr.length;i++){
            int res = 0;
            x = arr[i][0];
            y = arr[i][1];
            z = arr[i][2];
            if(x>0 && y>0 && z>0){
                int min = Math.min(x,y);
                min = Math.min(min,z);
                res = min*2;
                if(y-min>0){
                    res = res + (y-min-1);
                }
            }
            System.out.println(res);
        }
    }
}
