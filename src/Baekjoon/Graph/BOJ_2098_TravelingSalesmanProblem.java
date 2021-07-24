package Baekjoon.Graph;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2098_TravelingSalesmanProblem {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int answer = 99999999;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) W[i][j]=Integer.parseInt(st.nextToken(" "));
        }
        int[] arr = new int[N];
        DFS(N,0,arr,0);
        System.out.print(answer);
    }
    static void DFS(int length, int depth, int[] arr,int first){
        if(length == depth){
            int sum = W[first][arr[0]];
            for(int i=0;i<N-1;i++){
                sum+=W[arr[i]][arr[i+1]];
            }
            sum+=W[arr[length-1]][first];
            answer = Math.min(sum,answer);
        }
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i]=true;
            arr[depth]=i;
            DFS(length,depth+1,arr,first);
            visited[i]=false;
        }
    }
}
