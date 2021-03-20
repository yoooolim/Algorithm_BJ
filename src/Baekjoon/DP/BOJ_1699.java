package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1699 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=i;
            for(int j=(int)(Math.sqrt(i));j>1;j--){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        System.out.print(dp[n]);
    }
}
