package hot_100;

import java.util.Arrays;

public class 最长连续序列 {


    //排序+双指针
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){return 0;}
        int count = 1;
        int left = 0;
        int right = 0;
        int res = 0;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            right = i;
            if ((nums[right]==nums[right-1]+1)){
                count++;
            } else if ((nums[right]==nums[right-1])) {
                continue;
            }else {
                res = Math.max(res,count);
                count = 1;
                left=right;
            }
        }
        res = Math.max(res,count);
        return res;
    }
}
