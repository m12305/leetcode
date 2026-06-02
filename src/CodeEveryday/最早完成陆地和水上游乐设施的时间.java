package CodeEveryday;

public class 最早完成陆地和水上游乐设施的时间 {


    //时间复杂度o(n^2)
    public int earliestFinishTime2(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int finishTime = Integer.MAX_VALUE;

        int[] land = new int[landStartTime.length];
        int[] water = new int[waterStartTime.length];

        for (int i = 0; i < landStartTime.length; i++) {
            land[i] = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                if (waterStartTime[j] <= land[i]) {
                    if (land[i] + waterDuration[j] < finishTime) {
                        finishTime = land[i] + waterDuration[j];
                    }
                }else {
                    if (waterStartTime[j]+ waterDuration[j] < finishTime){
                        finishTime = waterStartTime[j]+ waterDuration[j];
                    }
                }
            }
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            water[i] = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < landStartTime.length; j++) {
                if (landStartTime[j] <= water[i]) {
                    if (water[i] + landDuration[j] < finishTime) {
                        finishTime = water[i] + landDuration[j];
                    }
                }else {
                    if (landStartTime[j]+ landDuration[j] < finishTime){
                        finishTime = landStartTime[j]+ landDuration[j];
                    }
                }
            }
        }
        return finishTime;
    }

    //时间复杂度o(n)
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int minEnd = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(landStartTime[i]+landDuration[i]<minEnd){
                minEnd = landStartTime[i]+landDuration[i];
            }
        }
        int minEnd2 = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            int s = Math.max(minEnd,waterStartTime[i]);
            if(s+waterDuration[i]<minEnd2){
                minEnd2 = s+waterDuration[i];
            }
        }
        int minEnd3 = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            if(waterStartTime[i]+waterDuration[i]<minEnd3){
                minEnd3 = waterStartTime[i]+waterDuration[i];
            }
        }
        int minEnd4 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int s = Math.max(minEnd3,landStartTime[i]);
            if(s+landDuration[i]<minEnd4){
                minEnd4 = s+landDuration[i];
            }
        }
        return Math.min(minEnd2,minEnd4);

    }



}
