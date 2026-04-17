package hot_100;

import sun.awt.util.IdentityArrayList;

import java.util.*;

public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer,List<Integer>> map = new HashMap<>();
            for (int j = i+1; j < nums.length; j++) {
                if (!map.containsKey(nums[j])){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    map.put((-nums[i]-nums[j]),list);
                }else {
                    map.get(nums[j]).add(nums[j]);
                    if (!have(res,map.get(nums[j]))){
                        res.add(map.get(nums[j]));
                    }
                    map.remove(nums[j]);
                }
            }
        }
        return res;
    }

    private boolean isSame(List<Integer> list1, List<Integer> list2) {
        // 先判断边界情况，如果list1为null直接返回false
        if (list1 == null) {
            return false;
        }
        // 如果list2为null且list1不为空，返回false
        if (list2 == null) {
            return false;
        }
        // 遍历list1中的每个元素，检查是否都在list2中存在
        for (Integer num : list1) {
            if (!list2.contains(num)) {
                return false;
            }
        }
        return true;
    }

    private boolean have (List<List<Integer>> res, List<Integer> list){
        for (List<Integer> i:res){
            if (isSame(i,list)){return true;}
        }
        return false;
    }
}
