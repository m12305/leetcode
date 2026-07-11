package CodeEveryday;

public class day_6_01 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        StringBuffer str = new StringBuffer();
        char[] m1 = s.toCharArray();
        char[] m2 = t.toCharArray();

        int n1 = m1.length - 1;
        int n2 = m2.length - 1;

        int flag = 0;

        while (n1 >= 0 || n2 >= 0) {
            if (n1 >= 0 && n2 >= 0) {
                int x1 = Integer.valueOf(m1[n1])-48;
                int x2 = Integer.valueOf(m2[n2])-48;
                //System.out.println(x2);
                int res = (x1 + x2 + flag) % 10;
                str.append(Integer.toString(res));
                flag = (x1 + x2 + flag) / 10;
                n1--;n2--;
            } else if (n1 >= 0) {
                int x1 = Integer.valueOf(m1[n1])-48;
                int res = (x1 + flag) % 10;
                str.append(Integer.toString(res));
                flag = (x1 + flag) / 10;
                n1--;
            } else {
                int x2 = Integer.valueOf(m2[n2])-48;
                int res = (x2 + flag) % 10;
                str.append(Integer.toString(res));
                flag = (x2 + flag) / 10;
                n2--;
            }
        }
        if(flag>0){str.append(Integer.toString(flag));}
        return str.reverse().toString();
    }
}
