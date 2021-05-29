package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_WorkBook {
    static int problemNum;
    static int setNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        problemNum = Integer.parseInt(st.nextToken(" "));
        setNum = Integer.parseInt(st.nextToken(" "));
        int[] isConnected = new int[problemNum+1];
        ArrayList<Node> sets = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        sets.add(new Node(0,new ArrayList<>()));
        for(int i=0;i<problemNum;i++){sets.add(new Node(i+1,new ArrayList<>()));}

        for(int i=0;i<setNum;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            sets.get(a).next.add(sets.get(b));
            isConnected[b]++;
        }

        for(int i=1;i<problemNum+1;i++){
            if(isConnected[i]==0) pq.offer(i);
        }
        while(!pq.isEmpty()){
            Node now = sets.get(pq.poll());
            sb.append(now.number+" ");
            for(int i=0;i<now.next.size();i++){
                if(--isConnected[now.next.get(i).number]==0) pq.offer(now.next.get(i).number);
            }
        }
        System.out.print(sb);
    }
    static class Node implements Comparable<Node>{
        int number;
        ArrayList<Node> next;
        Node(int number, ArrayList<Node> next){
            this.number = number;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return (this.number - o.number);
        }
    }
}
