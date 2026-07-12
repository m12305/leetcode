package CodeEveryday;

public class day_7_02 {

    public int solve (char[][] grid) {
        // write code here
        int res = 0;
        int[] dx = new int[]{1,0,-1,-0};
        int[] dy = new int[]{0,1, 0,-1};

        for(int i = 0;i<grid.length;i++){
            for(int j =0;j< grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j,dx,dy);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int x,int y,int[] dx,int[] dy){
        grid[x][y] = '0';
        for(int i = 0;i<4;i++){
            if(x+dx[i]>=0&& x+dx[i]<grid.length &&
                    y+dy[i]>=0 && y+dy[i]<grid[0].length&&
                    grid[(x+dx[i])][(y+dy[i])] =='1'){
                dfs(grid,x+dx[i],y+dy[i],dx,dy);
            }
        }
    }
}
