package Baekjoon.Input_and_Output;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10818_2 {
    //Using BufferReader instead of Scanner
    //dyd7100님 코드 참고
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;st.hasMoreTokens();i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int max = num[0], min = num[0];
        for(int i=1;i<num.length;i++){
            if(num[i]>max) max = num[i];
            else if(num[i]<min) min = num[i];
        }
        bw.write(String.valueOf(min)+" "+String.valueOf(max));

        bw.flush();
        bw.close();
    }
}
