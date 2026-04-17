package hot_100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 无重复最长子串 {


    //使用队列
    public int lengthOfLongestSubstring(String s) {
        //if (s.length()==0){return 0;}
        int res = 0;
        Queue<Character> queue = new LinkedList<>();
        //HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!queue.contains(s.charAt(i))){
                queue.add(s.charAt(i));
            }else {
                res = Math.max(res,queue.size());
                while (true){
                    if (queue.poll()==s.charAt(i)){
                        break;
                    }
                }
                queue.add(s.charAt(i));
            }
        }
        return Math.max(res,queue.size());
    }
}
