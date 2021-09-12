package Baekjoon;

import java.util.Scanner;

public class BOJ_1789_SumOfNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if(N==1) { System.out.print(1); return; }
        long start = (long)Math.sqrt(N);
        while((start*(start+1))/2<=N){
            start++;
        }
        System.out.print(start-1);
    }
}
