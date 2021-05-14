package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_5014_StartLink {
    static int floor;
    static int now;
    static int togo;
    static int up;
    static int down;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        floor = Integer.parseInt(str[0]);
        now = Integer.parseInt(str[1]);
        togo = Integer.parseInt(str[2]);
        up = Integer.parseInt(str[3]);
        down = Integer.parseInt(str[4]);
        visited = new boolean[floor][2];
        int[] dir = {up,-down};

        Queue<Elevator> q = new LinkedList<>();
        q.offer(new Elevator(0,now,0));
        q.offer(new Elevator(0,now,1));

        while(!q.isEmpty()){
            Elevator e = q.poll();
            int count = e.count;
            int nowFloor = e.nowFloor;
            int updown = e.updown;

            if(visited[nowFloor-1][updown]) continue;
            visited[nowFloor-1][updown]=true;

            if(nowFloor==togo){
                System.out.print(count);
                System.exit(0);
            }
            int nextFloor = nowFloor+dir[updown];
            if(!canGo(nextFloor)) continue;
            q.offer(new Elevator(count+1,nextFloor,0));
            q.offer(new Elevator(count+1,nextFloor,1));
        }
        System.out.print("use the stairs");
    }
    static class Elevator{
        int count;
        int nowFloor;
        int updown; //0->up 1->down
        Elevator(int count, int nowFloor, int updown){
            this.count = count;
            this.nowFloor = nowFloor;
            this.updown = updown;
        }
    }
    static boolean canGo(int f){
        if(f<=0||f>floor) return false;
        return true;
    }
}
