package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_JewelryTheif {
    static int jewelryNum;
    static int bagNum;
    static int[] bagWeight;
    static Jewelry[] jewelry;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        jewelryNum = Integer.parseInt(st.nextToken(" "));
        bagNum = Integer.parseInt(st.nextToken(" "));
        jewelry = new Jewelry[jewelryNum];
        bagWeight = new int[bagNum];
        PriorityQueue<Jewelry> q = new PriorityQueue<Jewelry>(new MyComparator());

        for(int i=0;i<jewelryNum;i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken(" "));
            int v = Integer.parseInt(st.nextToken(" "));
            jewelry[i] = new Jewelry(m,v);
        }
        for(int i=0;i<bagNum;i++){
            bagWeight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewelry);
        Arrays.sort(bagWeight);
        long result = 0;
        int rememberj = 0;
        int j;

        for(int i=0;i<bagNum;i++){
            for(j = rememberj ;j<jewelryNum;j++){
                if(bagWeight[i]<jewelry[j].weight) {
                    break;
                }
                q.offer(jewelry[j]);
            }
            rememberj = j;
            if(q.isEmpty()) continue;
            result += q.poll().price;
        }
        System.out.print(result);
    }
    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;
        Jewelry(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.weight-o.weight;
        }
    }
    public static class MyComparator implements Comparator<Jewelry>{
        @Override
        public int compare(Jewelry o1, Jewelry o2){
            return (o1.price<o2.price? 1: -1);
        }
    }
}
