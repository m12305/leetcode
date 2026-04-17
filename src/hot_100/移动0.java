package hot_100;

public class 移动0 {


    //双指针
    public void moveZeroes(int[] nums) {
        int index = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i]==0){
                index=i;
                break;
            }
            if (i== nums.length-1){
                return;
            }
        }
        for (; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[j]=0;
        }
    }


    //双指针，代码更简洁
    public void moveZeroes2(int[] nums) {
        int cur = 0;
        int index = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                nums[index++] = nums[cur];
            }
            cur++;
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


}
