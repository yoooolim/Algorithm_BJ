package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11727 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] way = new int[n+1];
        way[1]=1;
        if(n!=1) way[2]=3;
        for(int i=3;i<n+1;i++){
            way[i]=(way[i-1]+way[i-2]*2)%10007;
        }
        System.out.print(way[n]);
    }
}
