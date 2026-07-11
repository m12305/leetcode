package CodeEveryday;

public class day_6_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/c4c488d4d40d4c4e9824c3650f7d5571
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        if(s.equals("0") || t.equals("0")){return "0";}
        // write code here
        char[] m1 = s.toCharArray();
        char[] m2 = t.toCharArray();

        int ml1 = m1.length;
        int ml2 = m2.length;

        StringBuffer str = new StringBuffer();

        int[] arr = new int[ml1+ml2+1];

        int index = 0;

        for(int i = ml1-1; i>=0;i--){
            int temp = index;
            for(int j= ml2-1; j>=0;j--){
                arr[temp] = (Integer.valueOf(m1[i])-48)*(Integer.valueOf(m2[j])-48) + arr[temp];
                temp++;
            }
            index++;
        }
        //System.out.println(arr[2]);
        int x = 0;
        for(int i = 0;i<arr.length;i++){
            int num = arr[i] + x;
            if(num==0){break;}
            str.append(Integer.toString(num%10));
            x = num/10;
        }
        //if(x>0){str.append(Integer.toString(x));}
        return str.reverse().toString();
    }
}
