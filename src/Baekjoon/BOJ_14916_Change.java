package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_14916_Change {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int two = 0;
        while(money>0){
            if(money%5==0){
                two+=money/5;
                break;
            }
            money-=2;
            two++;
        }
        if(money<0) System.out.print(-1);
        else System.out.print(two);
    }
}
