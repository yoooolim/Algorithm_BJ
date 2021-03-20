package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11057 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] way = new int[2][11];
        for(int i=1;i<11;i++) way[0][i]=1; //initialization
        for(int i=1;i<n;i++){
            int now = i%2;
            int bef = (i-1)%2;
            for(int j=1;j<11;j++) way[now][j]=(way[now][j-1]+way[bef][j])%10007;
        }
        int sum=0;
        for(int i=1;i<11;i++) sum=(sum+way[(n-1)%2][i])%10007;
        System.out.println(sum);
    }
}
