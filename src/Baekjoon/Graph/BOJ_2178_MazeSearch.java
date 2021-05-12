package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_MazeSearch {
    static int N;
    static int M;
    static int [][] maze;
    public static void main(String[] args)throws Exception{
        // input and initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        maze = new int[N][M];
        boolean [][][]visited = new boolean[N][M][4];
        Queue<Maze> q = new LinkedList<>();
        int []moveX = {1,-1,0,0}; // → ← ↑ ↓
        int []moveY = {0,0,-1,1}; // → ← ↑ ↓
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                maze[i][j] = str.charAt(j)-'0';
            }
        }
        // algorithm start
        q.offer(new Maze(0,0,1));

        while(!q.isEmpty()){
            Maze m = q.poll();
            int x = m.getX();
            int y = m.getY();
            int cnt = m.getCnt();

            if(x==N-1&&y==M-1){
                System.out.print(cnt);
                System.exit(0);
            }

            for(int i=0;i<4;i++){
                int nx = x+moveX[i];
                int ny = y+moveY[i];
                if(canGo(nx,ny)){
                    if(visited[nx][ny][i]) continue;
                    visited[nx][ny][i]=true;
                    q.offer(new Maze(nx,ny,cnt+1));}
            }
        }
    }
    static boolean canGo(int x, int y){
        if(x<0||y<0||x>=N||y>=M||maze[x][y]==0) return false;
        return true;
    }
    static class Maze{
        int x;
        int y;
        int cnt;

        Maze(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        int getX(){return this.x;}
        int getY(){return this.y;}
        int getCnt(){return this.cnt;}
    }
}

