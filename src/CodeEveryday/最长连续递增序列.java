package CodeEveryday;

public class 最长连续递增序列 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length==0){return 0;}
        int left = 0;
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                res = Math.max(res, (i-left+1));
            }else {
                left = i;
            }
        }
        return res;
    }
}
