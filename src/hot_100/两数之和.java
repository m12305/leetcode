package hot_100;

import java.util.HashMap;

public class 两数之和 {

    //双层循环嵌套
    public int[] twoSum1(int[] nums, int target) {
        //int[] res = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //用哈希
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(target-nums[i],i);
            }else {
                return new int[]{map.get(nums[i]),i};
            }
        }
        return null;
    }


}
