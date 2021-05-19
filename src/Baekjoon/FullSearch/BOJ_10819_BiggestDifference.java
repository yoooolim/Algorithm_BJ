package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_BiggestDifference {
    private static int inputNum;
    private static int[] array;
    private static int[] permutation;
    private static boolean[] visited;
    private static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputNum = Integer.parseInt(br.readLine());
        array = new int[inputNum];
        permutation = new int[inputNum];
        visited = new boolean[inputNum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<inputNum;i++) array[i] = Integer.parseInt(st.nextToken(" "));
        getMaxUsingPermutation(0);
        System.out.print(result);
    }
    private static void getMaxUsingPermutation(int count){
        if(count == inputNum){
            int sum=0;
            for(int i=0;i<inputNum-1;i++){
                sum+=Math.abs(permutation[i]-permutation[i+1]);
            }
            result = Math.max(sum,result);
            return;
        }
        for(int i=0;i<inputNum;i++){
            if(visited[i]) continue;
            visited[i]=true;
            permutation[count]=array[i];
            getMaxUsingPermutation(count+1);
            visited[i]=false;
        }
    }
}
