import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2917_WolfHunter {

    final static int[][] dir = {{-1,0,1,0},{0,1,0,-1}};
    static int min = Integer.MAX_VALUE;
    static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        solution(input());
    }

    private static int[][] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Point> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = Integer.MAX_VALUE;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<temp.length();j++){
                char ch = temp.charAt(j);
                if(ch=='+') { q.offer(new Point(i, j, 0)); }
                else {
                    if(ch=='V'){ startX=i; startY=j; }
                    else if(ch=='J'){ endX=i; endY=j; }
                    grid[i][j] = maxNum;
                }
            }
        }
        while(!q.isEmpty()){
            Point now = q.poll();
            int distance = now.distance+1;
            for(int i=0;i<4;i++){
                int nx = now.x+dir[0][i];
                int ny = now.y+dir[1][i];
                if(canGo(nx,ny,n,m)&&grid[nx][ny]>distance){
                    grid[nx][ny]=distance; q.offer(new Point(nx,ny,grid[nx][ny]));
                }
            }
        }
        min = Math.min(grid[startX][startY],grid[endX][endY]);
        return grid;
    }

    private static boolean canGo(int x, int y, int n, int m){
        if(x<0||y<0||x>=n||y>=m) return false;
        return true;
    }

    private static void solution(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(startX,startY,grid[startX][startY]));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            min = Math.min(now.distance,min);
            if(now.x==endX&&now.y==endY) break;
            for(int i=0;i<4;i++){
                int nx = now.x + dir[0][i];
                int ny = now.y + dir[1][i];
                if(canGo(nx,ny,n,m)&&grid[nx][ny]!=-1){
                    pq.offer(new Point(nx,ny,grid[nx][ny])); grid[nx][ny]=-1;
                }
            }
        }
        System.out.print(min);
    }

    private static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;
        Point(int x, int y){ this.x=x; this.y=y; this.distance=-1;}
        Point(int x, int y, int distance){ this.x=x; this.y=y; this.distance = distance; }
        @Override
        public int compareTo(Point p){
            return(this.distance==p.distance)?0:(this.distance>p.distance)? -1:1;
        }
    }
}
