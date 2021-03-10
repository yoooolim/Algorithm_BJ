package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9461 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n+1];
        int max = 0;
        for(int i=0;i<n;i++){
            seq[i]=Integer.parseInt(br.readLine());
            max = Math.max(seq[i],max);
        }
        long[] dp = new long[100]; //int형은 다 담지 못함!
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<max;i++){
            dp[i]=dp[i-3]+dp[i-2];
        }
        for(int i=0;i<n;i++) System.out.println(dp[seq[i]-1]);
    }
}
