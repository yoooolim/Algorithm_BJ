package Baekjoon.DP;
//내리막길
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_1520_DownHill {
    static int M,N;
    static int[][] map,dp;
    static int[] dirX = {-1,0,1,0};
    static int[] dirY = {0,1,0,-1};
    public static void main(String[] agrs) throws IOException{
        input();
        solution();
    }
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken(" "));
        N = Integer.parseInt(st.nextToken(" "));
        map = new int[M][N]; dp=new int[M][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken(" "));
                dp[i][j] = -1;
            }
        }
    }
    static void solution(){
        System.out.print(DFS(0,0));
    }
    static int DFS(int x, int y){
        dp[x][y]=0;
        for(int i=0;i<4;i++){
            int nx = x + dirX[i]; int ny = y + dirY[i];
            if(nx<0||ny<0||nx>=M||ny>=N||map[x][y]<=map[nx][ny]) continue;
            if(nx==M-1&&ny==N-1) {
                dp[x][y]+=1;
            }
            if(dp[nx][ny]>=0) dp[x][y]+=dp[nx][ny];
            else dp[x][y]+=DFS(nx,ny);
        }
        return dp[x][y];
    }
}