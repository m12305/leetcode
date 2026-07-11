package CodeEveryday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class day_5_02 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://www.nowcoder.com/practice/54ab9865ce7a45968b126d6968a77f34
     *
     * @param grid int整型ArrayList<ArrayList<>>
     * @return int整型
     */
    public int rotApple (ArrayList<ArrayList<Integer>> grid) {
        // write code here
        int xmax = grid.size();
        ArrayList<Integer> m = grid.get(0);
        int ymax = grid.get(0).size();

        int time = -1;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                int temp = grid.get(i).get(j);
                if (temp == 1) {
                    fresh++;
                } else if (temp == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[] dy = new int[] {1, 0, -1, 0};
        int[] dx = new int[] {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for (int j = 0; j < 4; j++) {
                    int tempx = x+dx[j];
                    int tempy = y+dy[j];
                    if (tempx>=0 && tempx<xmax && tempy>=0 && tempy<ymax && grid.get(tempx).get(tempy) == 1){
                        queue.add(new int[]{tempx,tempy});
                        ArrayList<Integer> mm = grid.get(tempx);
                        mm.set(tempy,2);
                        grid.set(tempx,mm);
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh > 0) {
            return -1;
        }
        return time;
    }

}
