package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9465 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testnum = Integer.parseInt(br.readLine());
        int best[] = new int[testnum];
        for(int i=0;i<testnum;i++){
            int n = Integer.parseInt(br.readLine());
            int [][] sticker = new int[2][n+1];
            for(int j=0;j<2;j++){
                String line = br.readLine();
                String[] num = line.split(" ");
                for(int k=1;k<n;k++) sticker[j][k]=Integer.parseInt(num[k]);
            }
        }
    }
    public static int bestChoice(int[][] sticker){
        int max = 0;
        int sum=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<sticker[0].length;j++){
                sum+=sticker[i/2][j];
                if(max<sum) max=sum;
            }
        }
        return max;
    }
}
