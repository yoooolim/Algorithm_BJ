package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] step = new int[n];
        for(int i=0;i<n;i++) step[i]=Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        dp[2]=step[0];
        for(int i=3;i<n+2;i++) dp[i]=Math.max(dp[i-2]+step[i-2],dp[i-3]+step[i-3]+step[i-2]);
        System.out.print(dp[n+1]);
    }
}
