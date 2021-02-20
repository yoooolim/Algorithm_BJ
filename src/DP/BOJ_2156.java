package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] jar = new int[n];
        for(int i=0;i<n;i++){
            jar[i]=Integer.parseInt(br.readLine());
        }
        int [][] choice = new int [n+1][n+2];
        for(int i=0;i<n;i++){
            choice[0][i+2]=jar[i];
        }
        choice[1][2]=jar[0];
        for(int i=1;i<n;i++){
            choice[1][i+2]=max(choice[1][i+1],jar[i-1]+jar[i]);
        }
        for(int i=2;i<n;i++){
            for(int j=2;j<n+2;j++){
                choice[i][j]=max(choice[i][j-1],choice[i-1][j-2]+jar[j-2]);
            }
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+2;j++){
                System.out.print(choice[i][j]+"     ");
            }
            System.out.println();
        }
        System.out.println(choice[n][n+1]);
    }
    public static int max(int a, int b){
        if(a>b) return a;
        return b;
    }
}
