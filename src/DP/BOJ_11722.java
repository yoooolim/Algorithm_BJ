package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 가장 긴 감소하는 부분 수열 */
public class BOJ_11722 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] input = new int[n];
        int [] dp = new int[n];
        int [] sum = new int [n];
        int max = 1;

        for(int i=0;i<n;i++) input[i]=Integer.parseInt(st.nextToken(" "));

        dp[0]=1;

        for(int i=1;i<n;i++){
            dp[i]=1;
            sum[i]=input[i];
            for(int j=0;j<i;j++){
                if(input[j]>input[i]&&dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
