package CodeEveryday;

import java.util.Scanner;

public class day_7_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] arr = str.toCharArray();

        func(arr);

    }
    public static void func(char[] arr){
        int left = 0;
        StringBuffer res = new StringBuffer();
        int mlen = 0;
        int flag = 0;
        int[] m = new int[2];

        for(int i=0;i<arr.length;i++){
            if(isNum(arr[i]) && flag==0){
                left = i;
                flag = 1;
            }else if(!isNum(arr[i]) && flag==1){
                if(i-left>mlen){
                    mlen = i-left;
                    m[0] = left;
                    m[1] = i;
                }
                flag = 0;
            }else if(isNum(arr[i]) && i==arr.length-1 && flag==1){
                if(i-left+1>mlen){
                    mlen = i-left;
                    m[0] = left;
                    m[1] = i+1;
                }
            }
        }
        for(int i = m[0];i<m[1];i++){
            res.append(arr[i]);
        }
        System.out.printf(res.toString());
    }
    public static boolean isNum(char x){
        return (x>='0' && x<='9');
    }
}
