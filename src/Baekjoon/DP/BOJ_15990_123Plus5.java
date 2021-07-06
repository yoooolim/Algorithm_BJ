package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15990_123Plus5 {
    static int divide = 1000000009;
    static int dpNum = 100001;
    static long[][] dp;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new long[dpNum+1][4];
        dp[1][1]=dp[2][2]=dp[3][1]=dp[3][2]=dp[3][3]=1;
        for(int i=4;i<dpNum;i++){
            dp[i][1]=(dp[i-1][2]+dp[i-1][3])%divide;
            dp[i][2]=(dp[i-2][1]+dp[i-2][3])%divide;
            dp[i][3]=(dp[i-3][1]+dp[i-3][2])%divide;
        }

        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(br.readLine());
            sb.append((dp[now][1]+dp[now][2]+dp[now][3])%divide+"\n");
        }
        System.out.print(sb);
    }
}
