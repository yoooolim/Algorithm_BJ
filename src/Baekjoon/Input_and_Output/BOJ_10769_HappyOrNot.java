package Baekjoon.Input_and_Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10769_HappyOrNot {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int temp = 0, happy = 0, sad = 0;

        while((temp = str.indexOf(':'))!=-1&&str.length()>2){
            if(str.charAt(temp+2)=='('&&str.charAt(temp+1)=='-') sad++;
            else if(str.charAt(temp+2)==')'&&str.charAt(temp+1)=='-') happy++;
            str = str.substring(temp+3);
        }
        if(sad==happy){
            if(sad==0) System.out.print("none");
            else System.out.print("unsure");
        }
        else if(sad>happy) System.out.print("sad");
        else System.out.print("happy");
    }
}
