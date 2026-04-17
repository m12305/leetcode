package CodeEveryday;

import java.io.*;
import java.util.StringTokenizer;

public class 数组分三块最小最大和 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        // 读取数组并计算最大值和总和
        long total = 0;
        int maxVal = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        // 二分搜索最小可能的最大和
        long left = maxVal; // 至少包含最大元素
        long right = total; // 总和是上界
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canSplit(arr, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    // 检查是否可以将数组分成至多3部分，每部分和不超过S
    private static boolean canSplit(int[] arr, long S) {
        int parts = 0;
        long currentSum = 0;
        for (int num : arr) {
            if (num > S) {
                return false; // 单个元素已超过S，无法划分
            }
            if (currentSum + num > S) {
                parts++;
                currentSum = num;
                // 如果已经超过3部分，提前返回false
                if (parts > 3) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        // 最后一部分
        parts++;
        return parts <= 3;
    }
}