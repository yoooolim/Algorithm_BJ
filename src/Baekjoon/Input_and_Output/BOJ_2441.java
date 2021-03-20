package Baekjoon.Input_and_Output;

import java.io.*;

/*
코드 길이 줄이는 방법
BufferedWriter로 write하지 않고
StringBuilder로 String을 만들어서 한번에 출력하는 방법
본 코드에서는 BufferedReader/Writer 사용을 해보기 위해 BufferedWriter로 사용
*/

public class BOJ_2441 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n<1||n>100) System.exit(-1);
        for(int i=n;i>=1;i--){
            for(int j=0;j<n-i;j++) {
                bw.write(' ');
            }
            for(int j=0;j<i;j++) {
                bw.write('*');
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
