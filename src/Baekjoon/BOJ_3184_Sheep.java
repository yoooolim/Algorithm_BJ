package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3184_Sheep {
    static int R,C,wolf,sheep;
    static String[] fields;
    static boolean[][] visited;
    static int[] dirX = {-1,0,1,0};
    static int[] dirY = {0,1,0,-1};
    public static void main(String[] args)throws IOException{
        input();
        solution();
    }
    public static void solution(){
        int wolfExist = 0, sheepExist=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!visited[i][j]&&fields[i].charAt(j)!='#'&&fields[i].charAt(j)!='.'){
                    wolf = 0; sheep = 0;
                    DFS(i,j);
                    if(wolf<sheep) sheepExist+=sheep;
                    else wolfExist += wolf;
                }
            }
        }
        System.out.print(sheepExist+" "+wolfExist);
    }
    public static void DFS(int x, int y){
        visited[x][y]=true;
        char now = fields[x].charAt(y);
        if(now=='v') wolf++;
        else if(now == 'o') sheep++;

        for(int i=0;i<4;i++){
            int nx = x+dirX[i];
            int ny = y+dirY[i];
            if(nx<0||ny<0||nx>=R||ny>=C||fields[nx].charAt(ny)=='#'||visited[nx][ny]) continue;
            DFS(nx,ny);
        }
    }
    public static void input()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken(" "));
        C = Integer.parseInt(st.nextToken(" "));
        fields = new String[R];
        for(int i=0;i<R;i++) fields[i]=br.readLine();
        visited = new boolean[R][C];
    }
}
