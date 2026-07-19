package CodeEveryday;

import java.util.LinkedList;
import java.util.Queue;

public class day_13_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=196&tqId=37149&ru=/exam/oj
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        int res = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int n : arr){
            if(!queue.contains(n)){queue.add(n);}
            else{
                res = Math.max(res,queue.size());
                while(queue.peek()!=n){
                    queue.poll();
                }
                queue.poll();
                queue.add(n);
            }
        }
        res = Math.max(res,queue.size());
        return res;
    }
}
