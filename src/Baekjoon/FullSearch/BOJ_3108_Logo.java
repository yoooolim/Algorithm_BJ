package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3108_Logo {
    public static void main(String [] args) throws Exception{
        //initialization
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Rectangle [] map = new Rectangle[N+1];
        boolean [] visited = new boolean[N+1];
        map[0]=new Rectangle(0,0,0,0);
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken(" "));
            int y1 = Integer.parseInt(st.nextToken(" "));
            int x2 = Integer.parseInt(st.nextToken(" "));
            int y2 = Integer.parseInt(st.nextToken(" "));
            map[i]=new Rectangle(x1,y1,x2,y2);
        }
        Queue<Integer> q = new LinkedList<>(); //for BFS
        int result = 0;

        //algorithm start
        for(int i=0;i<=N;i++){
            if(visited[i]) continue;
            q.offer(i);
            visited[i]=true;

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j=0;j<=N;j++){
                    if(cur==j||visited[j]||!isConnected(cur,j,map)) continue;
                    q.offer(i);
                    visited[i]=true;
                }
            }
            result++;
        }
        System.out.print(--result);
    }
    public static boolean isConnected(int cur, int next, Rectangle [] map){
        Rectangle curRec = map[cur];
        Rectangle nextRec = map[next];
        if((curRec.getX1() < nextRec.getX1() && nextRec.getX2() < curRec.getX2() && curRec.getY1() < nextRec.getY1() && nextRec.getY2() < curRec.getY2())
                || (curRec.getX1()> nextRec.getX1() && nextRec.getX2() > curRec.getX2() && curRec.getY1() > nextRec.getY1() && nextRec.getY2() > curRec.getY2())
                || curRec.getX2() < nextRec.getX1() || curRec.getX1() > nextRec.getX2() || curRec.getY2() < nextRec.getY1() || curRec.getY1() > nextRec.getY2())
            return false;
        return true;
    }
}


class Rectangle{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    Rectangle(int x1, int y1, int x2, int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}