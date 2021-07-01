package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_LossOfMuscle {
    static int N;
    static int K;
    static int[] exercise;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        K = Integer.parseInt(st.nextToken(" "));
        exercise = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) exercise[i]=Integer.parseInt(st.nextToken(" "));
        int[] arr = new int[N];
        DFS(N,0,arr);
        System.out.print(answer);
    }
    static void DFS(int length, int depth, int[] arr){
        if(length==depth){
            int muscle=500;
            for(int i=0;i<length;i++){
                muscle=muscle-K+arr[i];
                if(muscle<500) break;
            }
            if(muscle>=500) answer++;
        }
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i]=true;
            arr[depth]=exercise[i];
            DFS(length,depth+1,arr);
            visited[i]=false;
        }
    }
}
