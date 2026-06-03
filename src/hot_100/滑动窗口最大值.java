package hot_100;

import java.util.*;

public class 滑动窗口最大值 {

    //超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (k==1){return nums;}

        List<Integer> result = new ArrayList<>();
        Queue<Integer> temp =new LinkedList<>();

        int maxNum = getMax(nums,k-1, k);
        result.add(maxNum);

        for (int i = 0; i < k; i++) {
            temp.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (temp.peek()==maxNum){
                temp.poll();
                temp.add(nums[i]);
                maxNum = getMax(nums , i, k);
                result.add(maxNum);
                continue;
            }
            if (maxNum<nums[i]){
                maxNum = nums[i];
                temp.poll();
                temp.add(nums[i]);
            }else {
                temp.poll();
                temp.add(nums[i]);
            }
            result.add(maxNum);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private int getMax(int[] nums, int i, int k){
        int max = nums[i];
        for (int j = 1; j < k; j++) {
            max  = Math.max(max, nums[i - j]);
        }
        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


    //双端队列--单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // 窗口个数
        Deque<Integer> q = new ArrayDeque<>(); // 更快的写法见【Java 数组】

        for (int i = 0; i < n; i++) {
            // 1. 右边入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 注意保存的是下标，这样下面可以判断队首是否离开窗口

            // 2. 左边出
            int left = i - k + 1; // 窗口左端点
            if (q.getFirst() < left) { // 队首离开窗口
                q.removeFirst();
            }

            // 3. 在窗口左端点处记录答案
            if (left >= 0) {
                // 由于队首到队尾单调递减，所以窗口最大值就在队首
                ans[left] = nums[q.getFirst()];
            }
        }

        return ans;
    }


}
