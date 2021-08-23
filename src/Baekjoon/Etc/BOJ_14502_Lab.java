package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_Lab {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[] dirX = {-1,0,1,0}, dirY={0,1,0,-1};
    static ArrayList<Point> initVirus = new ArrayList<>();
    static int N,M,max = 0,initSafe=0;
    static int[][] original;
    public static void main(String[] args) throws IOException {
        input();
        solution(0);
        System.out.print(max);
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        original = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                original[i][j] = Integer.parseInt(st.nextToken());
                if(original[i][j]==2) initVirus.add(new Point(i,j));
                else if(original[i][j]==0) initSafe++;
            }
        }
    }
    private static void solution(int depth){
        if(depth==3){
            calculateVirus(); return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(original[i][j]==0){
                    original[i][j]=1;
                    solution(depth+1);
                    original[i][j]=0;
                }
            }
        }
    }
    private static void calculateVirus(){
        boolean[][] visited = new boolean[N][M];
        int count = initSafe;

        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<initVirus.size();i++) q.offer(initVirus.get(i));
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dirX[i];
                int ny = now.y + dirY[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<M&&!visited[nx][ny]&&original[nx][ny]==0){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny));
                    count--;
                }
            }
        }
        max = Math.max(max,count-3);
    }
    private static class Point{
        int x; int y;
        Point(int x, int y){ this.x=x; this.y=y; }
    }
}
