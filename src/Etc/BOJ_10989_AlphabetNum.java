package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10989_AlphabetNum {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] n = new int[26];
        for(int i=0;i<str.length();i++) n[str.charAt(i)-'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) sb.append(n[i]+" ");
        System.out.print(sb);
    }
}
