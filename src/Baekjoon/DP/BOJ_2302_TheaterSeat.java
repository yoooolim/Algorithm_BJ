package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2302_TheaterSeat {
    static int N,M;
    static int[] dp, vip;
    public static void main(String[] args) throws IOException{
        input();
        System.out.print(solution());
    }
    static void input()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[41];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=40;i++){dp[i]=dp[i-1]+dp[i-2];}
        vip = new int[M];
        for(int i=0;i<M;i++) vip[i]=Integer.parseInt(br.readLine());
    }
    static int solution(){
        if(N==M||N==1) return 1;
        int mul = 1;
        if(M==0) return dp[N];
        else if(M==1) return dp[vip[0]-1]*dp[N-vip[0]];
        mul*=dp[vip[0]-1];
        for(int i=1;i<M;i++) mul*=dp[vip[i]-vip[i-1]-1];
        mul*=dp[N-vip[vip.length-1]];
        return mul;
    }
}