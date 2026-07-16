package CodeEveryday;

public class day_10_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        if(prices.length==0 || prices.length==1){return 0;}
        // write code here
        int res = 0;
        int left = 0;
        int right = 1;
        while(right<prices.length){
            int temp = prices[right]-prices[left];
            if(temp >0 && temp>res){
                res = temp;
            }else if(temp <0){
                left = right;
            }
            right++;
        }
        return res;
    }
}
