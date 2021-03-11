package Etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
/*
    1. P : 메모리 초과
        => S : Collections.sort가 아닌 각 수의 개수를 세어서 진행 그렇군..

    2. P : ArrayIndexOutOfBoundsException: 709999
        => S : 그냥 복붙하다 생기는 문제!
 */

public class BOJ_10989_NumSort3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10000];
        for(int i=0;i<n;i++) num[Integer.parseInt(br.readLine())-1]++;
        for(int i=0;i<10000;i++){
            for(int j=0;j<num[i];j++) bw.write((i+1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
