package Baekjoon.Input_and_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/* ArrayList 보다는 HashSet이 시간적으로 빠르다! */

public class BOJ_1764_Hearsay {
    static int hearSayNum;
    static int inputNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        hearSayNum = Integer.parseInt(st.nextToken(" "));
        inputNum = Integer.parseInt(st.nextToken(" "));

        HashSet<String> hearSay = new HashSet<>();
        PriorityQueue<String> answer = new PriorityQueue<>();

        for(int i=0;i<hearSayNum;i++){
            hearSay.add(br.readLine());
        }
        for(int i=0;i<inputNum;i++){
            String temp = br.readLine();
            if(hearSay.contains(temp)) answer.offer(temp);
        }
        bw.write(answer.size()+"\n");
        while(!answer.isEmpty()) bw.write(answer.poll()+"\n");
        bw.flush();
    }
}
