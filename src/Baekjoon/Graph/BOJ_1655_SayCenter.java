package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1655_SayCenter {
    static int inputNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        inputNum = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<inputNum;i++){
            int num = Integer.parseInt(br.readLine());
            if(minHeap.size()==maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if(!minHeap.isEmpty()&&!maxHeap.isEmpty()){
                if(minHeap.peek()<maxHeap.peek()){
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.print(sb);
    }
    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1>=o2)? -1:1;
        }
    }
}
