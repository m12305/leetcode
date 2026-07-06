package CodeEveryday;

import java.util.Scanner;

public class day_1_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 2;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int res = count(b, num)-count(a-1,num);
            System.out.println(res);
        }
    }

    public static int count(int r, int num){
        int res = 0;
        int x = 1;
        int temp = 1;
        while(r>0){
            if(r%10>num){
                res+=(r/10+1)*x;
            }else if(r%10==num){
                if(temp==1){res+=(r/10+1)*x;}else{
                    res+=temp;
                }
                temp = temp + (r%10)*x;
            }else{
                res+=(r/10)*x;
            }
            x = x*10;
            r = r/10;
        }
        return res;
    }
}
