package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_HanoiTopMoveSequence {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        sb.append((int)(Math.pow(2,n)-1)+"\n");
        hanoi(n,1,3,2);
        System.out.print(sb);
    }
    private static void hanoi(int n, int start, int to, int via){
        if(n==1) printHanoi(start, to);
        else {
            hanoi(n-1,start, via, to);
            printHanoi(start,to);
            hanoi(n-1,via,to,start);
        }
    }
    private static void printHanoi(int start, int end){
        sb.append(start+" "+end+"\n");
    }
}
