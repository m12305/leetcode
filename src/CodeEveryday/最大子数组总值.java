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

    public long maxTotalValue2(int[] nums, int k) {
        if (nums.length==2){return Math.abs(nums[0]-nums[1]);}

        long res = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //if(nums[o1] == nums[o2]){return 1;}
                return nums[o1] - nums[o2];
            }
        });
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //if(nums[o1] == nums[o2]){return -1;}
                return nums[o2] - nums[o1];
            }
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            max.add(i);
            min.add(i);
        }

        while (!max.isEmpty() && !min.isEmpty()){
            if (nums[max.peek()]==nums[min.peek()]){break;}

            int maxnum = max.poll();
            while(!max.isEmpty() && nums[maxnum]==nums[max.peek()]){
                maxnum = Math.abs(maxnum-(length/2))<Math.abs(max.peek()-(length/2))?maxnum:max.poll();
            }
            int minnum = min.poll();
            while(!min.isEmpty() && nums[minnum]==nums[min.peek()]){
                minnum = Math.abs(minnum-(length/2))<Math.abs(min.peek()-(length/2))?minnum:min.poll();
            }

            int l = Math.min(maxnum,minnum);
            int r = Math.max(maxnum,minnum);
            int temp = Math.abs(nums[l]-nums[r]);

            while (l>0 || r<length){

                if (l>0){
                    l--;
                    if (k==0){break;}else {
                        res += temp;
                        k--;
                    }
                }else if (r<(length-1)){
                    r++;
                    if (k==0){break;}else {
                        res += temp;
                        k--;
                    }
                }else{
                    res += temp;
                    k--;
                    break;
                }

            }
            if (k==0){break;}
            max.poll();

        }
        return res;
    }


    private int[][] maxSt; // 最大值ST表
    private int[][] minSt; // 最小值ST表
    private int[] logTable; // 预处理log2值，加速区间查询

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return 0;

        // 1. 预处理log表，logTable[i] = floor(log2(i))
        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }
        int maxLevel = logTable[n] + 1;

        // 2. 构建ST表
        maxSt = new int[maxLevel][n];
        minSt = new int[maxLevel][n];
        for (int i = 0; i < n; i++) {
            maxSt[0][i] = nums[i];
            minSt[0][i] = nums[i];
        }

        for (int j = 1; j < maxLevel; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                int prev = j - 1;
                maxSt[j][i] = Math.max(maxSt[prev][i], maxSt[prev][i + (1 << prev)]);
                minSt[j][i] = Math.min(minSt[prev][i], minSt[prev][i + (1 << prev)]);
            }
        }

        // 3. 最大堆：存储三元组 [value, left, right]，按value降序排列
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // 初始加入所有左端点对应的最大子数组 [l, n-1]
        for (int l = 0; l < n; l++) {
            int val = getValue(l, n - 1);
            maxHeap.add(new int[]{val, l, n - 1});
        }

        long total = 0;
        // 4. 取前k个最大价值
        for (int i = 0; i < k; i++) {
            int[] curr = maxHeap.poll();
            int val = curr[0];
            int l = curr[1];
            int r = curr[2];

            total += val;

            // 如果还有更小的右端点，加入下一个子数组 [l, r-1]
            if (r > l) {
                int newVal = getValue(l, r - 1);
                maxHeap.add(new int[]{newVal, l, r - 1});
            }
        }

        return total;
    }

    // 查询区间 [l, r] 的价值：max - min
    private int getValue(int l, int r) {
        int len = r - l + 1;
        int k = logTable[len];
        int maxVal = Math.max(maxSt[k][l], maxSt[k][r - (1 << k) + 1]);
        int minVal = Math.min(minSt[k][l], minSt[k][r - (1 << k) + 1]);
        return maxVal - minVal;
    }

}
