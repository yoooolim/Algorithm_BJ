package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2075_NthLargestNumber {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer>[] stacks = new Stack[N];
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) stacks[i] = new Stack<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                stacks[j].push(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0;i<N;i++){
            pq.offer(new Number(i,stacks[i].pop()));
        }
        for(int i=0;i<N-1;i++){
            Number pop = pq.poll();
            pq.offer(new Number(pop.line,stacks[pop.line].pop()));
        }
        System.out.print(pq.poll().num);
    }
    private static class Number implements Comparable<Number>{
        int line; int num;
        Number(int line, int num){
            this.line=line; this.num=num;
        }

        @Override
        public int compareTo(Number o) {
            return (this.num>o.num)? -1:1;
        }
    }
}
