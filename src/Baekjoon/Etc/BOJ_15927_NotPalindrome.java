package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15927_NotPalindrome {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringBuilder ori = new StringBuilder(br.readLine());
        StringBuilder reverse = new StringBuilder(ori.toString());
        ori.reverse();
        int n = ori.length();
        if(!ori.toString().equals(reverse.toString())) { System.out.print(n); return; }
        if(!ori.delete(0,1).toString().equals(reverse.delete(n-1,n).toString())) { System.out.print(n-1); return; }
        System.out.print(-1);
    }
}
