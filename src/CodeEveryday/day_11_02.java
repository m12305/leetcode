package CodeEveryday;

public class day_11_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/9e5e3c2603064829b0a0bbfca10594e9
     * 计算最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        // write code here
        int res = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            int temp = prices[right] - prices[left];
            if (temp > 0 && temp > 0) {
                res += temp;
                left = right;
            } else if (temp < 0) {
                left = right;
            }
            right++;
        }
        return res;
    }
}
