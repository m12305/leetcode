package hot_100;

import java.util.HashMap;

public class 爬楼梯 {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int climbStairs1(int n) {
        if (n==0){return 0;}
        if (n==1){return 1;}
        if (n==2){return 2;}
        int cur;
        if (map.containsKey(n)){
            return map.get(n);
        }else {
            cur = climbStairs(n-1)+climbStairs(n-2);
        }
        return cur;
    }



    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
