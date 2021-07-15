package Baekjoon.Input_and_Output;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1436_MovieDirectorShun {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int number = 666;
        String str = Integer.toString(number);
        int count=1;
        while(count!=input){
            str = Integer.toString(++number);
            if(str.contains("666")) count++;
        }
        System.out.print(number);
    }
}
