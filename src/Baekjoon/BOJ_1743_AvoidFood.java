import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_AvoidFood {
    final static int[] dirX = {-1,0,1,0}, dirY = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        solution(input());
    }
    private static int[][] input() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1]=1;
        }
        return map;
    }
    private static void solution(int[][] map){
        int N = map.length;
        int M = map[0].length;
        int color = 2;
        int maxFood = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=1) continue;
                Queue<Point> q = new LinkedList<>();
                map[i][j]=color;
                q.offer(new Point(i,j));
                int foodCnt = 1;
                while(!q.isEmpty()){
                    Point now = q.poll();
                    for(int k=0;k<4;k++){
                        int nx = now.x+dirX[k];
                        int ny = now.y+dirY[k];
                        if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]!=1)continue;
                        foodCnt++;
                        map[nx][ny]=color;
                        q.offer(new Point(nx,ny));
                    }
                }
                color++;
                maxFood = Math.max(maxFood,foodCnt);
            }
        }
        System.out.print(maxFood);
    }
    private static class Point{
        int x; int y;
        Point(int x, int y){ this.x=x; this.y=y; }
    }
}
