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
        for(int i=0;i<=N;i++){ //모든 사각형 탐색
            if(visited[i]) continue; //이미 방문했으면 탐색 x
            q.offer(i); // queue에 있는 요소 탐색
            visited[i]=true; //탐색 로그

            while(!q.isEmpty()){
                int cur = q.poll(); //q에서 꺼내서
                for(int j=0;j<=N;j++){
                    if(cur==j||visited[j]||!isConnected(cur,j,map)) continue;
                    //탐색하고 있는 자신이거나, 이미 방문했거나, 겹치지 않은 도형이라 판단되면 queue에 넣지 않음
                    q.offer(j);
                    visited[j]=true;
                }
            }
            result++;
        }
        System.out.print(--result);
    }
    public static boolean isConnected(int cur, int next, Rectangle [] map){
        Rectangle curRec = map[cur];
        Rectangle nextRec = map[next];
        /*
        순서대로 next
        사각형이 cur 사각형을 포함하는 경우 ||
        next 사각형이 cur 사각형에 포함되는 경우 ||
        오른쪽에 있는 경우 || 왼쪽에 있는 경우 || 위에 있는 경우 || 아래 있는 경우
         */
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
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
}