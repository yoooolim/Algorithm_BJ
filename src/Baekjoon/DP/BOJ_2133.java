package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2133 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n%2==1) System.out.print(0);
        else{
            int[]dp=new int[n];
            dp[2]=3;
            dp[4]=15;
        }
    }
}
