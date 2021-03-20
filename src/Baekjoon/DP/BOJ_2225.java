package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int k = Integer.parseInt(st.nextToken(" "));
        long[][] dp = new long[2][201];
        for(int i=0;i<k;i++) dp[0][i]=i+1;
        for(int i=1;i<n;i++){
            dp[i%2][0]=1;
            for(int j=1;j<k;j++) dp[i%2][j]=(dp[i%2][j-1]+dp[(i-1)%2][j])%1000000000;
        }
        System.out.print(dp[(n-1)%2][k-1]);
    }
}
