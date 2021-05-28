package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1655_SayCenter {
    static int inputNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputNum = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        for(int i=0;i<inputNum;i++){
            pq.offer(Integer.parseInt(br.readLine()));
            if(i==0||i%2==1) System.out.print(pq.peek()+"\n");
            else {
                pq.poll();
                System.out.print(pq.peek() + "\n");
            }
        }
    }
    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1>=o2)? 1:-1;
        }
    }
}
