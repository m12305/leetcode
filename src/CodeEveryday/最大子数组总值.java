package CodeEveryday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class 最大子数组总值 {

    //同一个子数组不能重复选
    public long maxTotalValue1(int[] nums, int k) {

        //if (nums.length==2){return Math.abs(nums[0]-nums[1]);}

        long res = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        });
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            max.add(i);
            min.add(i);
        }

        while (!max.isEmpty() && !min.isEmpty()){
            //if (max.peek()==min.peek()){break;}
            //if (nums[max.peek()]==nums[min.peek()]){break;}
            int l = Math.min(max.peek(),min.peek());
            int r = Math.max(max.peek(),min.peek());
            int temp = Math.abs(nums[l]-nums[r]);

            while (l>0 || r<length-1){
                if (k==0){break;}else {
                    res += temp;
                    k--;
                }

                if (l>0){
                    l--;
                }else if (r<length-1){
                    r++;
                }
            }
            if (k==0){break;}
            max.poll();
        }
        return res;
    }

}
