package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] jar = new int[n+1];
        for(int i=1;i<=n;i++){
            jar[i]=Integer.parseInt(br.readLine());
        }
        int[] choice = new int[n+1];
        choice[1]=jar[1];
        if(n>1) choice[2]=jar[1]+jar[2];
        for(int i=3;i<n+1;i++) choice[i]=Math.max(choice[i-1],Math.max(choice[i-2]+jar[i],choice[i-3]+jar[i-1]+jar[i]));
        System.out.println(choice[n]);
    }
}
