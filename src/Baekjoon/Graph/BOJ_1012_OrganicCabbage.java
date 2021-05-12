package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_OrganicCabbage {
    static int N;
    static int M;
    static boolean[][] cabbage;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        for(int i=0;i<testCase;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken(" ")); //가로
            N = Integer.parseInt(st.nextToken(" ")); //세로
            int cabNum = Integer.parseInt(st.nextToken(" "));
            cabbage = new boolean[N][M];
            for(int j=0;j<cabNum;j++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken(" "));
                int x = Integer.parseInt(st.nextToken(" "));
                cabbage[x][y]=true;
            }
            result.append(countWarmNum(cabbage)+"\n");
        }
        System.out.print(result.toString());
    }
    public static int countWarmNum(boolean[][] cabbage){
        int result = 0;
        boolean[][] visited = new boolean[cabbage.length][cabbage[0].length];
        for(int i=0;i<cabbage.length;i++){
            for(int j=0;j<cabbage[0].length;j++){
                if(visited[i][j]||!cabbage[i][j]) continue;
                dfs(i,j,visited);
                result++;
            }
        }
        return result;
    }
    public static void dfs(int x, int y, boolean[][] visited){
        visited[x][y]=true;
        if(canGo(x-1,y,visited)) dfs(x-1,y,visited);
        if(canGo(x+1,y,visited)) dfs(x+1,y,visited);
        if(canGo(x,y-1,visited)) dfs(x,y-1,visited);
        if(canGo(x,y+1,visited)) dfs(x,y+1,visited);
    }
    public static boolean canGo(int x, int y,boolean[][] visited){
        if(x<0||y<0||x>N-1||y>M-1||visited[x][y]||cabbage[x][y]==false) return false;
        return true;
    }
}
