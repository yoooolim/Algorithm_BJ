package Baekjoon.Etc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1786_Find {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        int idx = text.indexOf(pattern);
        int patternLen = pattern.length();
        List<Integer> finds = new ArrayList<>();
        while(idx>=0){
            finds.add(idx);
            text = text.substring(idx+1);
            idx = text.indexOf(pattern);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(finds.size()+"\n");
        int sum=0;
        for(int item : finds) bw.write((sum+=item+1)+" ");
        bw.flush();
    }
}
