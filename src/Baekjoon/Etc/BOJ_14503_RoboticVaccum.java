package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_RoboticVaccum {
    static int N,M, cleanNum;
    static int[] info = new int[3];
    static boolean[][] isWall,isVisited;
    static int[] dx = {-1,0,1,0};//위,오른쪽,아래,왼쪽
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        isWall = new boolean[N][M];
        isVisited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++) info[i]=Integer.parseInt(st.nextToken(" "));
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                if(st.nextToken(" ").equals("1")) isWall[i][j]=true;
            }
        }clean(info[0],info[1],info[2]);
        System.out.print(cleanNum);
    }
    static void clean(int x, int y, int d){
        boolean isAB = false;
        if(isVisited[x][y]==false) {
            isVisited[x][y] = true;
            cleanNum++;
        }
        for(int i=0;i<4;i++){
            int nd = (d+3)%4;
            int nx = x+dx[nd];
            int ny = y+dy[nd];
            if(nx>0&&ny>0&&nx<N&&ny<M&&!isVisited[nx][ny]&&!isWall[nx][ny]){
                clean(nx,ny,nd); isAB=true; break;
            }
            d=nd;
        }
        if(!isAB){
            int nd = (d+2)%4;
            int nx=x+dx[nd];
            int ny = y+dy[nd];
            if(nx>0&&ny>0&&nx<N&&ny<M&&!isWall[nx][ny]) clean(nx,ny,d);
        }
    }
}
