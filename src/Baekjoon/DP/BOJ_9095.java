package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
n의 값이 11보다 작다 이기 때문에 11까지의 way를 다 구해 놓고
입력 받은 값을 출력 하는 코드가 더 빠르다.
*/

public class BOJ_9095 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] input= new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(br.readLine());
            if(max<input[i]) max = input[i];
        }
        int [] way = new int[max];
        way[0]=1;
        if(max>0) way[1]=2;
        if(max>1) way[2]=4;
        for(int i=3;i<max;i++){
            way[i]=way[i-3]+way[i-2]+way[i-1];
        }
        for(int i=0;i<n;i++){
            bw.write(way[input[i]-1]+"\n");
        }
        bw.flush();
    }
}
