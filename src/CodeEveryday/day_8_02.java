package CodeEveryday;

import java.util.Arrays;

public class day_8_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/eac1c953170243338f941959146ac4bf?tpId=196&tqId=37143&ru=/exam/oj
     * max increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int MLS (int[] arr) {
        // write code here
        int res = 1;
        int temp = 1;

        Arrays.sort(arr);

        for(int i = 0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==1){
                temp++;
                res = Math.max(res,temp);
            }else if(arr[i+1]-arr[i]==0){
                continue;
            }else{
                temp = 1;
            }

        }
        return res;
    }
}
