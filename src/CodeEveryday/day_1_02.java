package CodeEveryday;

import java.util.ArrayList;
import java.util.HashSet;

public class day_1_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums1 int整型ArrayList
     * @param nums2 int整型ArrayList
     * @return int整型ArrayList
     */
    public ArrayList intersection (ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        // write code here
        ArrayList res = new ArrayList();
        HashSet<Integer> n1 = new HashSet();
        for(int i: nums1){
            n1.add(i);
        }
        for(int i: nums2){
            if(n1.contains(i)){
                res.add(i);
                n1.remove(i);
            }
        }
        return res;
    }
}
