package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_11656_SuffixArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String st = br.readLine();
        String copy = new String(st);
        ArrayList<String> ary = new ArrayList<>();
        for(int i=0;i<st.length();i++){
            ary.add(copy.substring(i));
        }
        Collections.sort(ary);
        for(int i=0;i<st.length();i++){
            bw.write(ary.get(i)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
