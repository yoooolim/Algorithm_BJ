package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10809_FindAlphabet {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append(str.indexOf(Character.toString((char)(i+'a')))+" ");
        }
        System.out.print(sb);
    }
}
