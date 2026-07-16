package CodeEveryday;

import java.util.Arrays;

public class day_9_03 {

    public boolean IsContinuous (int[] numbers) {
        // write code here
        Arrays.sort(numbers);
        int count = 0;
        int num = -1;

        for(int i = 0;i<numbers.length;i++){
            if(numbers[i]==0){
                count++;
            }else{
                if(num==-1){num = numbers[i];}
                else if(numbers[i]-num ==1){num++;}
                else if(numbers[i]-num ==0){return false;}
                else {if(count<(numbers[i]-num-1)){return false;}else{count = count - (numbers[i]-num-1);num = numbers[i];}}
            }
        }
        return true;
    }
}
