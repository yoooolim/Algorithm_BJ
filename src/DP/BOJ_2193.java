package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
피보나치 수열으로 푸는 방법도 있다!
일차원적으로 생각하지 말고, 더 분석 할 것~
*/

public class BOJ_2193 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long way[][] = new long[2][2]; //int형을 사용하면 범위를 벗어나게 된다
        way[0][1]=1;
        for(int i=1;i<n;i++){
            int now = i%2;
            int bef = (i-1)%2;
            way[now][0]=way[bef][0]+way[bef][1];
            way[now][1]=way[bef][0];
        }
        System.out.print(way[(n-1)%2][0]+way[(n-1)%2][1]);
    }
}
