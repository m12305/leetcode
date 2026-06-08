package CodeEveryday;

import java.util.ArrayDeque;
import java.util.Deque;

public class 根据给定数字划分数组 {

    //双端队列 时间复杂度o(n) 空间复杂度o(n)
    public int[] pivotArray(int[] nums, int pivot) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int n : nums ){
            if (n>pivot){
                q.addLast(n);
            }
            if (n<pivot){
                q.addFirst(n);
            }
        }
        int l = 0;
        int r = nums.length-1;
        while (!q.isEmpty()){
            int n = q.removeLast();
            if (n>pivot){
                nums[r--] = n;
            }
            if (n<pivot){
                nums[l++] = n;
            }
        }
        for (int i = l; i <=r; i++) {
            nums[i] = pivot;
        }
        return nums;
    }
}
