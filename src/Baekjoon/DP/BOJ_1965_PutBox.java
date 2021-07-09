package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1965_PutBox {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        int[] dp = new int[N];
        int max= 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            dp[i]=1;
            box[i] = Integer.parseInt(st.nextToken(" "));
            for(int j=i-1;j>=0;j--){
                if(box[j]<box[i]&&(dp[j]+1)>dp[i]){
                    dp[i] = dp[j]+1; max = Math.max(max,dp[i]);
                }
            }
        }
        System.out.print(max);
    }
}
