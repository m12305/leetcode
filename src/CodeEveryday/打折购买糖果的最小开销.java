package CodeEveryday;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 打折购买糖果的最小开销 {

    public int minimumCost(int[] cost) {
        if (cost==null){return 0;}
        if (cost.length==1){return cost[0];}
        if(cost.length==2){return cost[0]+cost[1];}
        Arrays.sort(cost);
        int sum=0;
        int i = cost.length-1;
        for (; i-1 > 0; i = i-3) {
            sum+=cost[i];
            sum+=cost[i-1];
        }
        for (int j = i; j >=0; j--) {
            sum+=cost[j];
        }
        return sum;
    }
}
