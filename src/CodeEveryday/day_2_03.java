package CodeEveryday;

import java.util.Scanner;

public class day_2_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = new String[in.nextInt()];

        String str1 = in.next();
        String str2 = in.next();
        in.nextLine();

        for(int i = 0;i<strs.length;i++){
            strs[i] = in.nextLine();
        }

        System.out.println(func(strs, str1, str2));
    }

    public static int func(String[] strs, String str1, String str2){
        int flag = -1;
        int l = -1;
        int res = Integer.MAX_VALUE;

        for(int i = 0;i<strs.length;i++){

            if(strs[i].equals(str1)){
                if(flag==1){
                    res = Math.min(res,(i-l));
                }
                l=i;
                flag = 0;
            }else if(strs[i].equals(str2)){
                if(flag==0){
                    res = Math.min(res,(i-l));
                }
                l=i;
                flag = 1;
            }else{
                continue;
            }
        }
        if(res==Integer.MAX_VALUE){return -1;}
        return res;
    }
}
