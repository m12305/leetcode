package CodeEveryday;

import java.util.ArrayList;
import java.util.List;

public class 可被5整除的二进制前缀 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        long num = 0;
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            num = num*2+nums[i];
            if (num%5==0){
                res.add(true);
            }else {
                num = num%5;
                res.add(false);
            }
        }
        return res;
    }
}
