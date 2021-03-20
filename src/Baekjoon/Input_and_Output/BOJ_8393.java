package Baekjoon.Input_and_Output;

import java.util.Scanner;

public class BOJ_8393 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        if(n<1||n>10000) System.exit(-1);
        int addNum = n+1;
        result = addNum*(n/2);
        if(n%2!=0) {
            result+=addNum/2;
        }
        System.out.println(result);
    }
}
