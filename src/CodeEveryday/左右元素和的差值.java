package CodeEveryday;

import java.util.Arrays;

public class 左右元素和的差值 {

    public int[] leftRightDifference(int[] nums) {
        int sl = 0;
        int sr = Arrays.stream(nums).sum();
        int length = nums.length;
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            sl = sl + (i>0?nums[i-1]:0);
            sr = sr - nums[i];
            res[i] = Math.abs(sl- sr);
        }
        return res;
    }

}
