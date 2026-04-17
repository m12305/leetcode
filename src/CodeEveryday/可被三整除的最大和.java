package CodeEveryday;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class 可被三整除的最大和 {

    //心态崩了
    public int maxSumDivThree(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                a.add(num);
            } else if (num % 3 == 2){
                b.add(num);
            }
        }

        a.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        b.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        if (sum%3==0){return sum;}
        if (sum%3==1){
            if (!a.isEmpty()){
                sum = sum - a.get(0);
                return sum;
            }else {
                if (b.size()<2){return 0;}
                return sum-b.get(0)-b.get(1);
            }
        }
        if (sum%3==2){
            if (!b.isEmpty()){
                sum = sum - b.get(0);
                return sum;
            }else {
                if (a.size()<2){return 0;}
                return sum-a.get(0)-a.get(1);
            }
        }
        return 0;
    }
}
