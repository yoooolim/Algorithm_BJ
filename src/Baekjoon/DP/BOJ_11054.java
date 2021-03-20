package Baekjoon.DP;

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
        int[] asc = new int[n];
        int[] desc = new int[n];
        int[] dp = new int[n];
        asc[0]=1;
        desc[n-1]=1;
        int max = 0;
        for(int i=1;i<n;i++){
            asc[i]=1;
            desc[n-i-1]=1;
            for(int j=0;j<n;j++){
                if(input[i]>input[j]&&asc[i]<=asc[j]) asc[i]=asc[j]+1;
                if(input[n-i-1]>input[n-j-1]&&desc[n-i-1]<=desc[n-j-1]) desc[n-i-1]=desc[n-j-1]+1;
            }
        }
        for(int i=0;i<n;i++){
            dp[i]=asc[i]+desc[i]-1;
            max=Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
