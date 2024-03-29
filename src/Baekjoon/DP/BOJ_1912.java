package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    dp[n+1][n+1] -> 메모리 초과
        ==> 슬라이딩 배열 dp[2][n+1] -> 바로 위의 값만 필요하기 때문
    슬라이딩 배열 -> 시간 초과 어쩌라는거쥐 ㅠㅠㅠ -> 다른 방법을 찾으라는 거겠지
*/

public class BOJ_1912 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] seq = new int[n];
        for(int i=0;i<n;i++) seq[i]=Integer.parseInt(st.nextToken(" "));
        int[] dp = new int[n];
        dp[0]=seq[0];
        int max = dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+seq[i],seq[i]);
            max = Math.max(dp[i],max);
        }
        System.out.print(max);
        /*
        int [][] dp = new int[2][n+1];
        seq[0]=0;
        for(int i=0;i<n+1;i++) dp[0][i]=seq[i];
        int max = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i%2][j]=Math.max(dp[(i-1)%2][j-1]+seq[j],dp[(i-1)%2][j]);
                max=Math.max(max,dp[i%2][j]);
            }
        }
        System.out.println(max);*/
    }
}
