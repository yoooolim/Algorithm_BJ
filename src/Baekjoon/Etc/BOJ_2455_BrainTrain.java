package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2455_BrainTrain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remain = Integer.parseInt(br.readLine().substring(2));
        int max = remain;
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            remain -=Integer.parseInt(st.nextToken(" "))-Integer.parseInt(st.nextToken(" "));
            max = Math.max(max,remain);
        }
        System.out.print(max);
    }
}