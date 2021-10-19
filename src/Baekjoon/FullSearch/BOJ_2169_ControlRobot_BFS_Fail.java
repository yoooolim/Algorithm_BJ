import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2169_ControlRobot_BFS_Fail {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[] dirX = {0,1,0}, dirY = {1,0,-1};
    static int N,M,maxValue;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        input();
        boolean[][] initVisited = new boolean[N][M];
        initVisited[0][0] = true;
        bfs(0,0,initVisited,board[0][0]);
        System.out.print(maxValue);
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxValue=Integer.MIN_VALUE;
        board = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
             board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    private static void bfs(int x, int y, boolean[][] visited, int sumValue){
        if(x==N-1&&y==M-1){
            maxValue = Math.max(maxValue,sumValue);
            return;
        }
        for(int i=0;i<3;i++){
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
            visited[nx][ny] = true;
            bfs(nx,ny,visited,sumValue+board[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}
