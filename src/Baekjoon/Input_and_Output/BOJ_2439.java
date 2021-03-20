package Baekjoon.Input_and_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2439 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n<1||n>100) System.exit(-1);
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++) {
                bw.write(' '); // write(" ")보다 fast!
            }
            for(int j=0;j<i;j++) {
                bw.write('*');
            }
            bw.write("\n"); // bw.newLine()보다 fast!
        }
        bw.flush();
        bw.close();
    }
}
