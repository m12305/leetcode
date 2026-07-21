package CodeEveryday;

import java.util.Arrays;

public class day_13_03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/6c3a5604cf274b2287fbe27c5dc74743?tpId=196&tqId=40510&ru=/exam/oj
     *
     * @param str string字符串
     * @return string字符串
     */
    public String rearrangestring(String str) {
        // write code here
        int maxN = Integer.MIN_VALUE;
        int[] nums = new int[26];
        char[] chrs = str.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            nums[chrs[i] - 'a']++;
            maxN = Math.max(maxN, nums[chrs[i] - 'a']);
        }
        if (maxN > (chrs.length - maxN) + 1) {
            return "";
        }
        quickSort(chrs, 0, chrs.length - 1, nums);
        int start = 0;
        int previousNum = -1;
        for (int i = 0; i < chrs.length; i++) {
            int currentNum = nums[chrs[i] - 'a'];
            if (currentNum != previousNum) {
                Arrays.sort(chrs, start, i);
                start = i;
                previousNum = currentNum;
            }
        }
        Arrays.sort(chrs, start, chrs.length);
        char[] res = new char[chrs.length];
        int p1 = 0;
        int p2 = 0;
        while (p2 < res.length) {
            res[p2] = chrs[p1];
            p2 += 2;
            p1++;
        }
        p2 = 1;
        while (p2 < res.length) {
            res[p2] = chrs[p1];
            p2 += 2;
            p1++;
        }
        StringBuffer sb = new StringBuffer("");
        for (char chr : res) {
            sb.append(chr);
        }
        return new String(sb);
    }

    public void quickSort(char[] chrs, int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int l = start - 1;
        int r = end + 1;
        int p = start;
        char chr = chrs[end];
        while (p < r) {
            if (nums[chrs[p] - 'a'] > nums[chr - 'a']) {
                char swap = chrs[p];
                chrs[p] = chrs[l + 1];
                chrs[l + 1] = swap;
                p++;
                l++;
            } else if (nums[chrs[p] - 'a'] < nums[chr - 'a']) {
                char swap = chrs[p];
                chrs[p] = chrs[r - 1];
                chrs[r - 1] = swap;
                r--;
            } else {
                p++;
            }
        }
        quickSort(chrs, start, l, nums);
        quickSort(chrs, r, end, nums);
    }

}
