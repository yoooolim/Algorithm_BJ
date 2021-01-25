package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463_rec {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(recursive(n));
    }
    public static int recursive(int n){
        if(n<=1) return 0;
        int a = recursive(n/3) + n%3 + 1;
        int b = recursive(n/2) + n%2 + 1;
        return a < b ? a : b;
    }
}
