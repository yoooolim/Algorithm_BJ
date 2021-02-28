package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] input = new int[n];
        for(int i=0;i<n;i++) input[i]=Integer.parseInt(st.nextToken(" "));
        int[] dp = new int[n];
        dp[0]=1;
    }
}
