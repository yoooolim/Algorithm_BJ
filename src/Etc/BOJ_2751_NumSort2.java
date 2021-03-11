package Etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
/*
    Array.sort ->
    Buffered Writer 사용해야지 시간초과가 뜨지 않는다
*/

public class BOJ_2751_NumSort2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0;i<n;i++) seq.add(Integer.parseInt(br.readLine()));
        Collections.sort(seq);
        for(int i=0;i<n;i++) bw.write(seq.get(i)+"\n");
        bw.flush();
        bw.close();
    }
}
