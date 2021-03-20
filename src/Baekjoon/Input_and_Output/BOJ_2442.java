package Baekjoon.Input_and_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2442 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                bw.write(' ');
            }
            for(int j=0;j<2*i+1;j++){
                bw.write('*');
            }
            bw.newLine();
        }
        bw.flush();
    }
}
