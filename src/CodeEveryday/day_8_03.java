package CodeEveryday;

import java.util.Scanner;

public class day_8_03 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int[][] arr = new int[n][m];

        for(int i = 0;i<n;i++){
            String str = in.nextLine();
            for(int j = 0;j<m;j++){
                arr[i][j] = score(str.charAt(j));
            }
        }
        int res = dfs(arr, 0, 0);
        System.out.println(res);
    }
    public static int dfs(int[][] arr, int x,int y){
        int res = arr[x][y];
        int right = 0;
        int down = 0;
        if(y+1<arr[0].length){right = dfs(arr,x,y+1);}
        if(x+1<arr.length){down = dfs(arr,x+1,y);}
        return Math.max(res+right,res+down);
    }
    public static int score(char x){
        if(x=='l'){return 4;}
        else if(x=='o'){return 3;}
        else if(x=='v'){return 2;}
        else if(x=='e'){return 1;}
        else {return 0;}
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                char  c = str.charAt(j);
                int score = 0;
                if (c == 'l') score = 4;
                else if (c == 'o') score = 3;
                else if (c == 'v') score = 2;
                else if (c == 'e') score = 1;
                nums[i][j] = score;
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = nums[i][j] +  Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
