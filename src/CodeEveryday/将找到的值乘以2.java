package CodeEveryday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 将找到的值乘以2 {
    public int findFinalValue(int[] nums, int original) {
        int cur = original;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%original==0){
                set.add(nums[i]);
            }
        }
        while (set.contains(cur)){
            cur = cur*2;
        }
        return cur;
    }
}
