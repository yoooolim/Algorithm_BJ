package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2346_PopBalloon {
    static int N;
    static List<Balloon> balloons;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        balloons = new ArrayList<>();
        for(int i=0;i<N;i++)
            balloons.add(new Balloon(i+1,Integer.parseInt(st.nextToken(" "))));

        Balloon now = balloons.get(0);
        sb.append(now.idx+" ");
        int count = 0;
        int before = 0;

        for(int i=0;i<N-1;i++){
            before=balloons.indexOf(now);
            count = now.num+before;
            if(count>0){
                while(count>=balloons.size()) count-=balloons.size();
            }
            else if(count<0){
                while(count<0) count+=balloons.size();
                if(count==before&&count!=0) count--;
                else if(count==before) count = balloons.size()-1;
            }
            now = balloons.get(count);
            balloons.remove(before);
            sb.append(now.idx+" ");
        }
        System.out.print(sb);
    }
    static class Balloon{
        int idx;
        int num;
        Balloon(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}

/*
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_2346_PopBalloon {
    static int N;
    static Deque<Balloon> dq;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dq = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)
            dq.offerLast(new Balloon(i+1,Integer.parseInt(st.nextToken(" "))));

        Balloon now = dq.poll();
        sb.append(now.idx+" ");

        while(!dq.isEmpty()){
            if(now.num<0){
                now.num = -now.num;
                for(int i=0;i<now.num-1;i++){
                    dq.offerFirst(dq.pollLast());
                }
                now = dq.pollLast();
            }
            else if(now.num>0){
                for(int i=0;i<now.num-1;i++){
                    dq.offer(dq.poll());
                }
                now = dq.poll();
            }
            sb.append(now.idx+" ");
        }
        System.out.print(sb);
    }
    static class Balloon{
        int idx;
        int num;
        Balloon(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}
*/