package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 字母异位词分组 {


    public List<List<String>> groupAnagrams(String[] strs) {

        return null;
    }



    //排序。。。
    public List<List<String>> groupAnagrams1(String[] strs) {
         HashMap<String,List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] cur = str.toCharArray();
            Arrays.sort(cur);
            String m = new String(cur);;
            List<String> list = map.getOrDefault(m, new ArrayList<String>());
            list.add(str);
            map.put(m,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
