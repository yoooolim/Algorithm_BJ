package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11655_ROT13 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if('A'<=sb.charAt(i)&&'Z'>=sb.charAt(i)) {
                if('M'>=sb.charAt(i))sb.setCharAt(i, (char) ((int) sb.charAt(i) + 13));
                else sb.setCharAt(i, (char) ((int) sb.charAt(i) - 13));
            }
            else if('a'<=sb.charAt(i)&&'z'>=sb.charAt(i)) {
                if('m'>=sb.charAt(i))sb.setCharAt(i, (char) ((int) sb.charAt(i) + 13));
                else sb.setCharAt(i, (char) ((int) sb.charAt(i) - 13));
            }
            ans.append(sb.charAt(i));
        }
        System.out.print(sb);
    }
}
