package hot_100;

import java.util.HashMap;
import java.util.Map;

public class 多数元素 {


    //哈希map
    public int majorityElement(int[] nums) {
        int numsize = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>numsize){
                return entry.getKey();
            }
        }
        return -1;
    }
}
