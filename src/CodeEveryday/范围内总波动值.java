package CodeEveryday;

import java.util.ArrayDeque;
import java.util.Deque;

public class 范围内总波动值 {

    //数位DP

    //如果long会超时
    public int totalWaviness(int num1, int num2) {

        if (num1<=100 && num2<=100){return 0;}

        int isfg = -1;
        int res = 0;

        for (int i = num1; i <= num2; i++) {
            int temp = i;
            Deque<Integer> q = new ArrayDeque<>();
            q.add(temp%10);
            temp = temp/10;
            while (temp!=0){
                if (isfg==-1){
                    int num = temp%10;
                    if (num>q.getLast()){isfg = 1;}
                    if (num<q.getLast()){isfg = 0;}
                    if (num==q.getLast()){q.removeFirst();}
                    q.add(num);
                    temp = temp/10;
                }else if (isfg==1){
                    int num = temp%10;
                    if (num<q.getLast()){res++; isfg = 0; q.removeFirst(); q.add(num);}
                    else if (num>q.getLast()){q.removeFirst(); q.add(num);}
                    else {isfg = -1; q.removeFirst();}
                    temp = temp/10;
                }else {
                    int num = temp%10;
                    if (num<q.getLast()){ q.removeFirst(); q.add(num);}
                    else if (num>q.getLast()){res++; isfg = 1; q.removeFirst(); q.add(num);}
                    else {isfg = -1; q.removeFirst();}
                    temp = temp/10;
                }
            }
            isfg = -1;
        }
        return res;
    }
}
