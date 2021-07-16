package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_Tower {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Tower> s = new Stack<>();
        for(int i=1;i<=N;i++) {
            long temp = Integer.parseInt(st.nextToken(" "));
            while(!s.isEmpty()){
                Tower to = s.peek();
                if(to.height>temp){sb.append(to.idx+" "); break;}
                s.pop();
            }
            if(s.isEmpty()) sb.append(0+" ");
            s.push(new Tower(i,temp));
        }
        System.out.print(sb);
    }
    static class Tower{
        int idx;
        long height;
        Tower(int idx, long height){
            this.idx = idx; this.height=height;
        }
    }
}
