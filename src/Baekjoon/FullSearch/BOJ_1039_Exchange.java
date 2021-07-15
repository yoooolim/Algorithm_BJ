package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039_Exchange {
    static int K;
    static String N;
    static boolean [][] visited;
    static Queue<Element> q;
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken(" ");
        K = Integer.parseInt(st.nextToken(" "));
        visited = new boolean[K+1][1000001];
        q = new LinkedList<>();
        BFS();
        System.out.print(max);
    }
    private static void BFS(){
        visited[0][Integer.parseInt(N)] = true; //바꾸지 않은 것! -> 0 / 현재 숫자
        q.offer(new Element(N,0));
        StringBuilder sb ;

        while(!q.isEmpty()){
            Element ele = q.poll();

            if(ele.count==K){
                max = Math.max(max,Integer.parseInt(ele.str));
                continue;
            }
            for(int i=0;i<ele.str.length()-1;i++){
                char front = ele.str.charAt(i);
                for(int j=i+1;j<ele.str.length();j++){
                    sb = new StringBuilder(ele.str);
                    char back = ele.str.charAt(j);
                    if(i==0&&back==0) continue;
                    sb.replace(i,i+1,Character.toString(back));
                    sb.replace(j,j+1,Character.toString(front));
                    if(visited[ele.count+1][Integer.parseInt(sb.toString())]) continue;
                    visited[ele.count+1][Integer.parseInt(sb.toString())]=true;
                    q.offer(new Element(sb.toString(),ele.count+1));
                }
            }
        }
    }
    static class Element{
        String str;
        int count;
        Element(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
}
