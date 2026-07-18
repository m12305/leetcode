package CodeEveryday;

import java.util.Scanner;

public class day_12_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        char[] arr = str.toCharArray();
        System.out.println(func(arr));
    }

    public static int func1(char[] arr){
        int n = arr.length;
        int num_y = 0;
        int[] num_hy = new int[n];
        int res = 0;
        for(int i = n-1;i>=0;i--){
            if(arr[i]=='y'){num_y++;}
            if(arr[i]=='h'){num_hy[i] = num_y;}
        }
        int num_s = 0;
        for(int i = 0;i<n;i++){
            if(arr[i]=='s'){num_s++;}
            if(arr[i]=='h'){res += num_hy[i]*num_s;}
        }
        return res;
    }

    //int 会溢出
    public static long func(char[] arr) { // 改成long防止溢出
        int n = arr.length;
        int num_y = 0;
        int[] num_hy = new int[n];
        long res = 0; // 结果用long
        // 逆序统计每个h后方y的数量
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'y') {
                num_y++;
            }
            if (arr[i] == 'h') {
                num_hy[i] = num_y;
            }
        }
        int num_s = 0;
        // 正序统计每个h前方s的数量，累加 s*y
        for (int i = 0; i < n; i++) {
            if (arr[i] == 's') {
                num_s++;
            }
            if (arr[i] == 'h') {
                res += (long) num_s * num_hy[i]; // 强转防止乘法中间溢出
            }
        }
        return res;
    }
}
