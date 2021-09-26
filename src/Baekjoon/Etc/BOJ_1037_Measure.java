package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1037_Measure {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        if(cnt == 1) {
            int in = Integer.parseInt(br.readLine());
            System.out.print(in*in);
        } else {
            int min = Integer.MAX_VALUE;
            int max = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<cnt;i++){
                int in = Integer.parseInt(st.nextToken());
                min = Math.min(min,in);
                max = Math.max(max,in);
            }
            System.out.print(min*max);
        }
    }
}
