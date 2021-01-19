package Input_and_Output;

import java.util.Scanner;

public class BOJ_11721 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int start=0;
        while((start+10)<str.length()){
            System.out.println(str.substring(start,start+10));
            start+=10;
        }
        System.out.println(str.substring(start));
    }
}
