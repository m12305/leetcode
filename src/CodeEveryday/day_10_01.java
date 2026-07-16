package CodeEveryday;

public class day_10_01 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af
     *
     * @param A string字符串
     * @return int整型
     */
    public int getLongestPalindrome (String A) {
        if (A == null || A.length() < 1) return 0;
        int maxLen = 0;
        for (int i = 0; i < A.length(); i++) {
            int len1 = expandAroundCenter(A, i, i);
            int len2 = expandAroundCenter(A, i, i + 1);
            int len = Math.max(len1, len2);
            maxLen = len > maxLen ? len : maxLen;
        }
        return maxLen;
    }
    private int expandAroundCenter(String A, int left, int right) {
        while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return right - left - 1;
    }
}
