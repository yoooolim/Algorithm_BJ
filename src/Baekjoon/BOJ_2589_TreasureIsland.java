import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2589_TreasureIsland {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[] dirX = {-1,0,1,0};
    final static int[] dirY = {0,1,0,-1};
    static int R,C, maxMove=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        solution();
    }
    private static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i=0;i<R;i++){
            String in = br.readLine();
            for(int j=0;j<C;j++){
                char ch = in.charAt(j);
                if(ch=='L') map[i][j] = 1;
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]==1){ //모든 육지에서 BFS
                    boolean[][] visited = new boolean[R][C];
                    Queue<Island> q = new LinkedList<>();
                    q.offer(new Island(i,j,0));
                    while(!q.isEmpty()){
                        Island now = q.poll();
                        visited[now.x][now.y] = true;
                        maxMove = Math.max(maxMove,now.time);
                        for(int k=0;k<4;k++){
                            int nx = now.x + dirX[k];
                            int ny = now.y + dirY[k];
                            if(canGo(nx,ny)&&!visited[nx][ny]&&map[nx][ny]==1){
                                visited[nx][ny] = true;
                                q.offer(new Island(nx,ny,now.time+1));
                            }
                        }
                    }
                }
            }
        }
        System.out.print(maxMove);
    }
    private static boolean canGo(int x, int y){
        return (x<0||y<0||x>=R||y>=C)? false : true;
    }
    private static class Island{
        int x; int y; int time;
        Island(int x, int y, int time){ this.x = x; this.y = y; this.time=time; }
    }
}
