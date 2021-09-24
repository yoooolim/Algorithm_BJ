import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206_BreakWallAndMove {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[][] dir = {{-1,0,1,0},{0,1,0,-1}};
    static int N, M;
    static boolean[][] isWall;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    private static void input() throws IOException {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        isWall = new boolean[N][M];
        visited = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                if(str.charAt(j)=='0') isWall[i][j]=false;
                else isWall[i][j]=true;
                visited[i][j]=Integer.MAX_VALUE;
            }
        }
        visited[0][0]=0;
    }
    private static void solution(){
        if(N==1&&M==1) { System.out.print(1); return; }
        Queue<Move> q = new LinkedList<>();
        q.offer(new Move(0,0,0,1));
        while(!q.isEmpty()){
            Move now = q.poll();
            int x = now.x;
            int y = now.y;
            int distance = now.distance+1;
            int isBreak = now.breakCnt;
            for(int i=0;i<4;i++){
                int nx = x+dir[0][i];
                int ny = y+dir[1][i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if((isWall[nx][ny]&&isBreak==1)||visited[nx][ny]<=isBreak) continue;
                if(nx==N-1&&ny==M-1) { System.out.print(distance); return; }
                if(isWall[nx][ny]) q.offer(new Move(nx,ny,1,distance));
                else q.offer(new Move(nx,ny,isBreak,distance));
                visited[nx][ny]=isBreak;
            }
        }
        System.out.print(-1);
    }
    private static class Move{
        int x; int y; int breakCnt; int distance;
        Move(int x, int y, int breakCnt, int distance){
            this.x=x; this.y=y; this.breakCnt=breakCnt; this.distance=distance;
        }
    }
}
