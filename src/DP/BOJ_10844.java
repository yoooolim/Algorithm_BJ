package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10844 {
    private static int MOD = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] way = new int[2][12];
        for(int i=2;i<11;i++) way[0][i]=1;
        for(int i=0;i<n;i++){
            int now = (i+1)%2, bef = i%2;
            for(int j=1;j<11;j++){
                way[now][j]=(way[bef][j-1]+way[bef][j+1])%MOD;
            }
        }
        int sum = 0;
        for(int i=0;i<11;i++) sum = (sum+way[(n-1)%2][i])%MOD;
        System.out.println(sum);
    }
}
