package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1388_FloorDecoration {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[] dirX = {0,0,1};//0->x / 1->- : 오른쪽 탐색 / 2->| : 아래쪽 탐색
    final static int[] dirY = {0,1,0};
    public static void main(String[] args) throws IOException {
        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] floor = new int[R][C];
        for(int i=0;i<R;i++){
            String temp = br.readLine();
            for(int j=0;j<C;j++){
                char ch = temp.charAt(j);
                if(ch=='-') floor[i][j] = 1;
                else floor[i][j] = 2;
            }
        }
        solution(floor,R,C);
    }
    private static void solution(int[][] floor,int R, int C){
        int count = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(floor[i][j]!=0){
                    int now = floor[i][j];
                    Queue<Point> q = new LinkedList<>();
                    q.offer(new Point(i,j));
                    while(!q.isEmpty()){
                        Point nowP = q.poll();
                        int nx = nowP.x+dirX[now];
                        int ny = nowP.y+dirY[now];
                        if(nx>=R||ny>=C) continue;
                        if(floor[nx][ny]==now) {
                            q.offer(new Point(nx, ny));
                            floor[nx][ny]=0;
                        }
                    }
                    count++;
                }
            }
        }
        System.out.print(count);
    }
    private static class Point{
        int x; int y;
        Point(int x, int y) { this.x=x; this.y=y; }
    }
}
