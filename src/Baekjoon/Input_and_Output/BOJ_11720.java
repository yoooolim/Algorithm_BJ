package Baekjoon.Input_and_Output;

import java.util.Scanner;

import static java.lang.System.exit;

public class BOJ_11720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num=0,nums=0,sum=0;
        num=sc.nextInt();
        sc.nextLine();

        if((num<1)||(num>100)) exit(1);
        nums=Integer.parseInt(sc.nextLine());

        for(int i=0;i<num;i++){
            sum+=nums%10;
            nums/=10;
        }
        System.out.println(sum);
    }
}
