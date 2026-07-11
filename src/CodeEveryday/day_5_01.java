package CodeEveryday;

public class day_5_01 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6
     *
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public int LastRemaining_Solution (int n, int m) {
        // write code here
        return func(n,m);
    }

    public int func(int n, int m){
        if(n==1){
            return 0;
        }
        int x= func(n-1,m);
        return (x+m)%n;
    }
}
