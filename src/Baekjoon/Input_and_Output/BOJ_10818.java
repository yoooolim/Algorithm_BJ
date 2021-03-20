package Baekjoon.Input_and_Output;

import java.util.Scanner;

public class BOJ_10818 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++) {num[i]=sc.nextInt();}
        int max = -1000000, min = 1000000;
        for(int i=0;i<n;i++){
            if(num[i]>max) max = num[i];
            if(num[i]<min) min = num[i];
        }
        System.out.println(min+" "+max);
    }
}//시간이 엄청 많이 걸린다...
